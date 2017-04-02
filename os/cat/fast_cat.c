#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define MAX_BUF_SIZE 8*16*1024
#define STDIN 0
#define STDOUT 1

char buf[2][MAX_BUF_SIZE];

int buf_len[2] = {0, 0};

pthread_mutex_t b0mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t b1mutex = PTHREAD_MUTEX_INITIALIZER;

pthread_cond_t b0cond = PTHREAD_COND_INITIALIZER;
pthread_cond_t b1cond = PTHREAD_COND_INITIALIZER;

int done = 0;

void *reader()
{
	int readed = 0;
	int buf_num = 0;

	while (1) {
		if (buf_num == 0) {
			pthread_mutex_lock(&b0mutex);
			while (buf_len[buf_num] > 0)
				pthread_cond_wait(&b0cond, &b0mutex);
		} else {
			pthread_mutex_lock(&b1mutex);
			while (buf_len[buf_num] > 0)
				pthread_cond_wait(&b1cond, &b1mutex);
		}

		readed = read(STDIN, buf[buf_num], MAX_BUF_SIZE);
		if (readed == -1) {
			perror("Failed to read data");
			exit(1);
		}

		buf_len[buf_num] += readed;
		if (readed == 0) {
			done = 1;
			buf[buf_num][readed] = '\0';
		}

		if (buf_num == 0) {
			pthread_cond_signal(&b0cond);
			pthread_mutex_unlock(&b0mutex);
		} else {
			pthread_cond_signal(&b1cond);
			pthread_mutex_unlock(&b1mutex);
		}

		if (done)
			break;

		buf_num = (buf_num + 1) % 2;
	}

	pthread_exit(NULL);
}

void *writer()
{
	int written = 0;
	int buf_num = 0;

	while (1) {
		if (buf_num == 0) {
			pthread_mutex_lock(&b0mutex);
			while (buf_len[buf_num] == 0) {
				if (done) {
					pthread_mutex_unlock(&b0mutex);
					pthread_exit(NULL);
				}
				pthread_cond_wait(&b0cond, &b0mutex);
			}
		} else {
			pthread_mutex_lock(&b1mutex);
			while (buf_len[buf_num] == 0) {
				if (done) {
					pthread_mutex_unlock(&b1mutex);
					pthread_exit(NULL);
				}
				pthread_cond_wait(&b1cond, &b1mutex);
			}
		}

		written = write(STDOUT, buf[buf_num], buf_len[buf_num]);
		if (written == -1) {
			perror("Failed to write data");
			exit(1);
		}

		buf_len[buf_num] -= written;

		if (buf_num == 0) {
			pthread_cond_signal(&b0cond);
			pthread_mutex_unlock(&b0mutex);
		} else {
			pthread_cond_signal(&b1cond);
			pthread_mutex_unlock(&b1mutex);
		}

		if (done)
			break;

		if (buf_len[buf_num] == 0)
			buf_num = (buf_num + 1) % 2;
	}

	pthread_exit(NULL);
}

int main()
{
	pthread_t r, w;
	
	if (pthread_create(&r, NULL, reader, NULL) != 0) {
		perror("Failed to create thread");
		exit(1);
	}
	if (pthread_create(&w, NULL, writer, NULL) != 0) {
		perror("Failed to create thread");
		exit(1);
	}

	if (pthread_join(r, NULL) != 0) {
		perror("Failed to join thread");
		exit(1);
	}
	if (pthread_join(w, NULL) != 0) {
		perror("Failed to join thread");
		exit(1);
	}

	if (pthread_mutex_destroy(&b0mutex) != 0) {
		perror("Failed to destroy mutex");
		exit(1);
	}
	if (pthread_cond_destroy(&b0cond) != 0) {
		perror("Failed to destroy condition");
		exit(1);
	}
	if (pthread_mutex_destroy(&b1mutex) != 0) {
		perror("Failed to destroy mutex");
		exit(1);
	}
	if (pthread_cond_destroy(&b1cond) != 0) {
		perror("Failed to destroy condition");
		exit(1);
	}

	return 0;
}

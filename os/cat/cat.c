#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define MAX_BUF_SIZE 16*16*1024
#define STDIN 0
#define STDOUT 1

char buf[MAX_BUF_SIZE];
int data_len = 0;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t bufcond = PTHREAD_COND_INITIALIZER; 

int done = 0;

void *reader()
{
	int readed = 0;

	while (1) {
		pthread_mutex_lock(&mutex);
		while (data_len > 0)
			pthread_cond_wait(&bufcond, &mutex);

		readed = read(STDIN, buf, MAX_BUF_SIZE);
		if (readed == -1) {
			perror("Failed to read data");
			exit(1);
		}

		data_len += readed;
		if (readed == 0) {
			done = 1;
			buf[readed] = '\0';
		}

		pthread_cond_signal(&bufcond);
		pthread_mutex_unlock(&mutex);

		if (done)
			pthread_exit(NULL);
	}
}

void *writer()
{
	int written = 0;

	while (1) {
		pthread_mutex_lock(&mutex);
		while (data_len == 0) {
			if (done) {
				pthread_cond_signal(&bufcond);
				pthread_mutex_unlock(&mutex);
				pthread_exit(NULL);
			}
			pthread_cond_wait(&bufcond, &mutex);
		}

		written = write(STDOUT, buf, data_len);
		if (written == -1) {
			perror("Failed to write data");
			exit(1);
		}

		data_len -= written;

		pthread_cond_signal(&bufcond);
		pthread_mutex_unlock(&mutex);

		if (done)
			pthread_exit(NULL);
	}
}

int main()
{
	int ret;
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

	if (pthread_mutex_destroy(&mutex) != 0) {
		perror("Failed to destroy mutex");
		exit(1);
	}
	if (pthread_cond_destroy(&bufcond) != 0) {
		perror("Failed to destroy condition");
		exit(1);
	}

	return 0;
}

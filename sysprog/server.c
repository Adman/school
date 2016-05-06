#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <signal.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <termios.h>
#include <unistd.h>
#include <sys/select.h>

#define STDIN 1
#define MAX_MSG 1024

int sockfd = -1;
struct termios termattr;

void write_msg(int fd, char *msg, int bytes)
{
	if (write(fd, msg, bytes) < 0) {
		if (sockfd > -1)
			close(sockfd);
		perror("Failed: write");
		exit(1);
	}
}

void print_time(void)
{
	time_t rawtime;
	struct tm * timeinfo;
	char buffer[30];

	time (&rawtime);
	timeinfo = localtime(&rawtime);

	strftime (buffer, 80, "[%H:%M] ", timeinfo);
	write_msg(STDIN, buffer, strlen(buffer));
}

void set_icanon(int mode)
{
	if (mode)
		termattr.c_lflag |= ICANON;
	else
		termattr.c_lflag &= ~ICANON;

	if (tcsetattr(STDIN, TCSANOW, &termattr) < 0) {
		perror("Failed: tcsetattr");
		close(sockfd);
		exit(1);
	}
}

void quit(int sig)
{
	if (sockfd > -1)
		close(sockfd);
	print_time();
	write_msg(STDIN, "Quit...\n", 8);
	exit(0);
}

int main(int argc, char *argv[])
{
	u_int16_t port = 12345;
	char buf[MAX_MSG+1];
	char prefix[] = "-> ";
	int bytes_read;
	int running;

	struct sockaddr_in me, client;

	socklen_t clientlen = sizeof(client);

	fd_set readfds;

	signal(SIGINT, quit);
	signal(SIGTERM, quit);

	if (argc > 1) {
		sscanf(argv[1], "%hu", &port);
	}

	if (tcgetattr(0, &termattr) < 0) {
		perror("Failed: tcgetattr");
		exit(1);
	}

	me.sin_family = AF_INET;
	me.sin_addr.s_addr = htonl(INADDR_ANY);
	me.sin_port = htons(port);

	if ((sockfd = socket(PF_INET, SOCK_DGRAM, 0)) == -1) {
		perror("Failed: socket");
		exit(1);
	}

	if (bind(sockfd, (struct sockaddr *)&me, sizeof(me)) == -1) {
		perror("Failed: bind");
		exit(1);
	}

	print_time();
	printf("Server started on port %d...\n", port);

	running = 1;
	while (running) {
		FD_ZERO(&readfds);
		FD_SET(sockfd, &readfds);
		FD_SET(STDIN, &readfds);

		set_icanon(0);
		if (select(sockfd+1, &readfds, NULL, NULL, NULL) < 0) {
			perror("Failed: select");
			close(sockfd);
			exit(1);
		}
		set_icanon(1);

		if (FD_ISSET(STDIN, &readfds)) {
			if (fgets(buf, MAX_MSG+1, stdin) == NULL) {
				running = 0;
			} else {
				if (sendto(sockfd, buf, strlen(buf), 0,
						(struct sockaddr*)&client,
						clientlen) < 0) {
					perror("Failed: sendto");
					close(sockfd);
					exit(-1);
				}
			}
		} else if (FD_ISSET(sockfd, &readfds)) {
			bytes_read = recvfrom(sockfd, buf, MAX_MSG, 0,
					(struct sockaddr*)&client, &clientlen);
			if (bytes_read < 0) {
				perror("Failed: recv");
				close(sockfd);
				exit(1);
			} else if (bytes_read > 0) {
				buf[bytes_read] = 0;
				print_time();
				write_msg(STDIN, prefix, 3);
				write_msg(STDIN, buf, bytes_read);
			}
		}
	}

	print_time();
	printf("Closing server...\n");
	close(sockfd);

	return 0;
}

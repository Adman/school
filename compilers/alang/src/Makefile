.DEFAULT_GOAL := build
.PHONY: build, library

build:
	javac *.java

library:
	gcc -shared -fPIC library.c -o library.so

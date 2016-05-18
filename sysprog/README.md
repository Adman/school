UDP Talker
==========

simple UDP talker allowing 2 users to communicate

## Usage
* compile `talker.c` using `gcc`
* start talker by running `$ ./talker_bin_name address [destport] [myport]`

Default values for both destport and myport are set to `12345``

If you want to run this program for both users on the same computer,
desport and myport have to be specified symetrically.
`user1 - Aport Bport`
`user2 - Bport Aport`

(c) 2016, Adrian Matejov (Final project - subject System Programming)

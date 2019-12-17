FILE=`readlink -f $1`

lli -load=./src/library.so $FILE

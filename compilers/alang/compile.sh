#!/bin/bash

FILE=`readlink -f $1`

pushd src 2>&1 > /dev/null
    java Compiler $FILE
popd 2>&1 > /dev/null

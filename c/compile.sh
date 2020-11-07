#!/bin/bash
gcc $1 -Wall -pthread -lm
if [ $? -eq 0 ]; then
    ./a.out
    # errorMensage=$(./a.out 2>&1)
    if [ $? -ne 0 ]; then
        echo $errorMensage
    fi    
    rm a.out
fi

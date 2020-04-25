#!/bin/bash

gcc copy.c -Wall -o q
if [ $? -eq 0 ]; then

    errorMensage=$(./q copy.c 2>&1)
    if [ $? -ne 0 ]; then
        echo $errorMensage
    fi    
    rm q
fi

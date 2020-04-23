#!/bin/bash
gcc copy.c -Wall -o q
if [ $? -eq 0 ]; then
    echo ""
    ./q copy.c
    rm q
fi

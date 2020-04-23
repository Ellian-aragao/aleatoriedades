#!/bin/bash

if [ -z $1 ]
then
    while [ -z $requisicao ]
    do
        read -p "Você esqueceu de colocar parâmetro (GET,POST,PUT,DELETE): " requisicao
        parametro_maiusculo=$(echo $requisicao | awk '{print toupper($1)}')
    done
else
    parametro_maiusculo=$(echo $1 | awk '{print toupper($1)}')
fi

case $parametro_maiusculo in
    GET)
        cat apache.log | grep GET
    ;;
    POST)
        cat apache.log | grep POST
    ;;
    PUT)
        cat apache.log | grep PUT
    ;;
    DELETE)
        cat apache.log | grep DELETE
    ;;
    *)
        echo "O parametro passado não é válido"
    ;;
esac

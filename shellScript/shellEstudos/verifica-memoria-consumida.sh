#!/bin/bash

memoria_total=$(free | grep Mem | awk '{ print $2 }')
memoria_usada=$(free | grep Mem | awk '{ print $3 }')
razao_memoria=$(bc <<< "scale=2;$memoria_usada/$memoria_total * 100" | awk -F. '{ print $1 }')
if [ $razao_memoria -gt 50 ]
then
    echo "usando mais que a metade da memória"
    #código para enviar o email
else
    echo "tudo okay"
fi

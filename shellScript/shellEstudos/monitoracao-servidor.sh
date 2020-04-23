#!/bin/bash

resposta_http=$(curl --write-out %{http_code} --silent --output /dev/null https://www.google.com)

if [ $resposta_http -eq 200 ]
then
    echo "Servidor funcionando normalmente"
else
    echo "reinicializando o servidor"
    #comandos que reinicializam o servidor
fi

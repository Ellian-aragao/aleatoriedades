#!/bin/bash

move_arquivos(){
    local extensao_diretorio=$1
    local lista=$(ls *.$extensao_diretorio 2> /dev/null)
    
    if [ -z $lista ]
    then
        echo "não há arquivos de extensão \"."$extensao_diretorio"\" para serem organizados"
    else
        for arquivo in $lista
        do
            verifica_diretorio $extensao_diretorio

            echo "movendo \""$arquivo"\" para pasta \""$extensao_diretorio"\""
            mv $arquivo $extensao_diretorio
        done
    fi
}

verifica_diretorio(){
    local diretorio=$1
    if [ ! -d $diretorio ]
    then
        echo ""
        echo "criando diretório \""$diretorio"\""
        mkdir $diretorio
    fi
}

echo "Organizando códigos para o URI"
echo ""
cd ../../organizacao

sourceExtecions=( "c" "cpp" "java" "py" )
i=0
while [ $i != ${#sourceExtecions[@]} ]
do
    move_arquivos ${sourceExtecions[$i]}
    let "i = i +1"
done

echo ""
echo "Script finalizado"

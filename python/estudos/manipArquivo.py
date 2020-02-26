# lê os arquivos
arquivo = open('orientacaoAObjeto.py','r')
linhas = arquivo.readlines()
for linha in linhas:
    print(linha)
arquivo.close()

# escreve uma cópia do arquivo
arquivo = open('testeDeCopia.py','w')
arquivo.writelines(linhas)
arquivo.close()

#exclui o arquivo criado
import os
os.remove('testeDeCopia.py')
arquivo = open('db.csv','r')
linhas = arquivo.readlines()
for linha in linhas:
    palavras = linha.split(',')
    
arquivo.close()

from orientacaoAObjeto import *

perfis = perfil.gerar_perfis('dbErrado.cvs','r')

arquivo = None
try:
    arquivo = open('dbErrado.csv','r')
    texto = arquivo.readlines()
    for frase in texto:
        palavra = frase.split(',')
        perfil(*palavra)
    print('arquivo aberto')
    arquivo.close()
except(TypeError) as e:
    print('erro {}'.format(e))
finally:
    if arquivo is not None:
        arquivo.close()
        print('arquivo fechado')
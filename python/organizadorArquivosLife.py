import os

varPath = '/home/ellian/Documents/lifecon/orgDocuments/arqu/CONTAS PAGAS - 02 - fevereiro - 2017'
anyThing = os.listdir(varPath)
# print(diretorio)

for oneThing in anyThing:
    fullPath = '{}/{}'.format(varPath,oneThing)
    if os.path.isdir(fullPath):
        print('true')

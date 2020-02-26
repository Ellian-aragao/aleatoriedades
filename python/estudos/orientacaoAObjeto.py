class perfil(object):
    'teste de classe perfil'
    
    # construtor
    def __init__(self,nome,numero,empresa):
        self.nome = nome
        self.numero = numero
        self.empresa = empresa
        self.__curtidas = 0
    
    def imprime(self):
        print ('nome: {}\nnumero: {}\nempresa: {}\ncurtidas: {}'.format(self.nome,self.numero,self.empresa,self.getCurtidas()))
    
    def curtir(self):
        self.__curtidas += 1
    
    def getCurtidas(self):
        return self.__curtidas
    
"""
# teste com o objeto
user = perfil('robertinho','84028922','caelum')
print ('curtidas: {}'.format(user.getCurtidas()))
user.curtir()
user.imprime()
for i in range(10):
    user.curtir()
print('----------------------------')
user.imprime()
"""
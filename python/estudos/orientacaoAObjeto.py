class perfil(object):
    'teste de classe perfil'
    
    def __init__(self,nome,numero,empresa):
        self.nome = nome
        self.numero = numero
        self.empresa = empresa
    
    def imprime(self):
        print ('nome: {}\nnumero: {}\nempresa: {}'.format(self.nome,self.numero,self.empresa))
        
"""
# teste com o objeto
user = perfil('robertinho','84028922','caelum')
user.imprime()
"""
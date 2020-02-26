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
    
class perfil_vip(perfil):
    'herda de perfil e incrementa'
    
    def __init__(self, nome, numero, empresa, apelido):
        super().__init__(nome, numero, empresa)
        self.apelido = apelido
    
    def obter_creditos(self):
        return self.getCurtidas() * 10
        
    def imprime(self):
        super().imprime()
        print('apelido: {}'.format(self.apelido))
        print('credito = R${:.2f}'.format(self.obter_creditos()))
    

# teste com o objeto
user = perfil_vip('roberto','84028922','caelum','dollynho')
user.curtir()
user.imprime()
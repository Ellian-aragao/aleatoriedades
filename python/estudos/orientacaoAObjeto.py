class perfil(object):
    'teste de classe perfil'
    
    # construtor
    def __init__(self,nome,numero,empresa):
        if len(nome) < 3:
            raise ValueError('o nome deve ter ao menos 3 caracteres')
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
    
    @classmethod
    def gerar_perfis(cls, nome_do_arquivo):
        arquivo = open(nome_do_arquivo,'r')
        linhas = arquivo.readlines()
        perfis = []
        for linha in linhas:
            palavras = linha.replace('\n','').split(',')
            if len(palavras) is not 3:
                raise ValueError('as linhas no arquivo {} devem ter 3 valores'.format(nome_do_arquivo))
            perfis.append(cls(*palavras))
        arquivo.close()
        return perfis

    
class perfil_vip(perfil):
    'herda de perfil e incrementa'
    
    def __init__(self, nome, numero, empresa, apelido = ''):
        super().__init__(nome, numero, empresa)
        self.apelido = apelido
    
    def obter_creditos(self):
        return self.getCurtidas() * 10
        
    def imprime(self):
        super().imprime()
        print('apelido: {}'.format(self.apelido))
        print('credito = R${:.2f}'.format(self.obter_creditos()))

"""
perfis = perfil_vip.gerar_perfis('db.csv')
for item in perfis:
    item.imprime()
    print('-----------')
"""
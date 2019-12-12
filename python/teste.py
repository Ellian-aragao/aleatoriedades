x = input().split()
for i in x:
    #position = i.find('(')
    num = i.find('seno(')
    if not num:
        for j, valor in enumerate(i):
            if i[j] == '(':
                valor = i.split('(')
                print(valor)
                num = valor.find(')')
                print(num)
    
    
    """
    if i.isnumeric():
        print('{} numérico'.format(i))
    else:
        print('{} não é numérico'.format(i))
    """
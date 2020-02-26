def paralelo(a0,a1):
    return ((a0 * a1)/(a0 + a1))

def serie(a0,a1):
    return (a0 + a1)

x = int(input('circuto paralelo? '))
if x == 1:
    n = [float(x) for x in input().split()]
    for i, valor in enumerate(n):
        if i == 1:
            valorParalelo = paralelo(n[i - 1],n[i])
        elif i > 1:
            valorParalelo = paralelo(valorParalelo, n[i])

    print('valor das resistências paralelas: {}'.format(valorParalelo))


x = int(input('circuto serie? '))
if x == 1:
    n = [float(x) for x in input().split()]
    valorSerie = 0
    for valor in n:
        valorSerie += valor
    
    print('valor das resistências em serie: {}'.format(valorSerie))
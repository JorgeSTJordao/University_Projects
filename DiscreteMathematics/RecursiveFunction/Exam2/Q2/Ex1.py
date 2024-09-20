def recursiva(a, x, y):
    if y < 2:
        i = (x * 2) ** y
        a.append(i)
        recursiva(a, x, y + 1)
    else:
        return a

vetor = []
termoInicial = 1
razao = 1
recursiva(vetor, termoInicial, razao)
print(vetor)
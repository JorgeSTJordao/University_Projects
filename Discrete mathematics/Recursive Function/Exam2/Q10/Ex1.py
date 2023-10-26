def A(n):
    p = 50000 * (3 * n)
    if n <= 30:
        A(n + 1)
    else:
        return print(p)

hora = 1
p = 0
A(hora)
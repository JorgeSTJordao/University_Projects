def A(n):
    p = 50000 * (3 * n)
    if p < 200000:
        A(n + 1)
    else:
        return print(n)

hora = 1
A(hora)
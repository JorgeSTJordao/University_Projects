def rec_triangulo(n):
    if n == 1:
        return 1
    else:
        return rec_triangulo(n - 1) + n

print(rec_triangulo(4))
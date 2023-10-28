from sympy import Symbol
def rec(fa, fb, flim):
    if flim == 1:
        return fa
    else:
         return rec((flim - 1) + )
def main():
    lim = int(input("Digite um número: "))
    a = Symbol("a")
    b = Symbol("b")
    i = 1
    print(rec(a, b, lim))

main()
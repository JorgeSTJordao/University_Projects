def rec(fa1, fr, fn):
    if fa1 == fn:
        return fa1
    else:
        return rec(fa1, fr, fn - 1)*fr

def main():
    a1 = int(input("Digite o termo raiz: "))
    r = int(input("Digite o valor da razão: "))
    n = int(input("Digite o número do índice: "))
    print(rec(a1, r, n))
main()
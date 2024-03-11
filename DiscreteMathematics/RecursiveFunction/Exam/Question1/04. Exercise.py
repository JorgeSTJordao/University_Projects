def rec(fn):
    if fn == 1:
        return 1
    else:
        return fn-1 + rec(fn - 1)*fn**2
def main():
    n = int(input("Digite o índice do elemento: "))
    print(rec(n))

main()
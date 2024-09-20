def rec(fn):
    if fn == 1:
        return 1
    else:
        return fn**2 + rec(fn - 1)

def main():
    n = int(input("Digite o índice do elemento: "))
    print(rec(n))
main()
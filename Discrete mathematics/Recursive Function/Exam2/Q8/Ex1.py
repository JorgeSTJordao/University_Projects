def rec(fn):
    if fn == 1:
        return 1
    else:
        return rec(fn - 1)*3

def main():
    n = int(input("Digite um número: "))
    print(rec(n))

main()
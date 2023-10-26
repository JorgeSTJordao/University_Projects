def rec(fn):
    if fn == 1:
        return 2
    else:
        return rec(fn - 1)*1/2
def main():
    n = int(input("Digite um número: "))
    print(rec(n))

main()
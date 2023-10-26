def rec(fn):
    if fn == 1:
        return 2
    else:
        return rec(fn - 1)
def main():
    n = int(input("Digite o índice do elemento: "))
    rec(n)
main()
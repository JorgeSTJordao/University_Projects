def rec(fn):
    if fn == 1:
        return 2
    else:
        return rec((fn - 1))**-1
        # fn = 2
def main():
    n = int(input("Digite o índice do elemento: "))
    print(rec(n))
main()
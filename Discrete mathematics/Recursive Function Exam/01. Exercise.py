def rec(fn):
    if fn == 1:
        return 10
    else:
        return 10 + rec(fn - 1)


def main():
    n = int(input("Digite o índice do elemento: "))
    print(rec(n))

if __name__ == "__main__":
    main()
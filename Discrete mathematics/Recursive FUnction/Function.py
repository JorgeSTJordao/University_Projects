def iter_(fn):
    i = fn

    if i == 10:
        pass
    else:
        print(f"{i}")
        print(iter_(i + 1))


def main():
    n = int(input("Digite um número menor que 10: "))
    iter_(n)

main()
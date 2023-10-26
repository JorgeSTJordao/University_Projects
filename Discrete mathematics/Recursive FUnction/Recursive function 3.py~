def iterativo(fnum1):
    mult = 1
    mult *= fnum1

    while fnum1 != 1:
        print(f"{mult}")
        fnum1 -= 1
        mult *= fnum1

    return mult

def recursive(fnum1):

    if fnum1 == 1:
        pass
    else:
        mult = fnum1 * recursive(fnum1 - 1)

def main():
    num1 = int(input("Digite um nº para calcular seu fatorial: "))

    print(f"O fatorial do número {num1}, por uma função simples, é {iterativo(num1)}")
    print(f"O fatorial do número {num1}, por uma função recursiva, é {iterativo(num1)}")

main()
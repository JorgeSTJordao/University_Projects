def iterativo(fnum1):
    mult = 1
    mult *= fnum1

    while fnum1 != 1:
        fnum1 -= 1
        mult *= fnum1
        print(f"{fnum1 + 1} x {fnum1} = {mult}")

    return mult

def recursive():
    pass

def main():
    num1 = int(input("Digite um nº para calcular seu fatorial: "))

    print(f"O fatorial do nº {num1} é {iterativo(num1)}")

main()
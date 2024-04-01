package a02_Fundamental.Exercicios.Decisoes;

import java.util.Scanner;

public class a04_ParImpar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int valor1 = input.nextInt();

        if (valor1 % 2 == 0)
            System.out.println("O valor " + valor1 +  " é par");
        else
            System.out.println("O valor " + valor1 +  " é ímpar");
    }
}

package a02_Fundamental.Exercicios.ExpressoesMatematicas;

import java.util.Scanner;

public class a01_Polinomio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Valor de a
        System.out.print("Digite o valor de a: ");
        int a = input.nextInt();

        //Valor de b
        System.out.print("Digite o valor de b: ");
        int b = input.nextInt();

        //Valor de c
        System.out.print("Digite o valor de c: ");
        int c = input.nextInt();

        //Valor de x
        System.out.print("Digite o valor de X: ");
        double x = input.nextDouble();

        double y = a*Math.pow(x, 2) + b*x + c;
        System.out.print(y);

    }
}

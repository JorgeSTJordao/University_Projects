package Aula_02_Logica_Repeticao.Exercicios;

import java.util.Scanner;

public class _02_EquacaoQuadratica {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor do coeficiente a: ");
        double a = input.nextDouble();

        System.out.print("Digite o valor do coeficiente b: ");
        double b = input.nextDouble();

        System.out.print("Digite o valor do coeficiente c: ");
        double c = input.nextDouble();

        double delta_sqrt = Math.sqrt(Math.pow(b, 2) - 4.0*a*c);

        double root1 = (-b + delta_sqrt)/2;
        double root2 = (-b - delta_sqrt)/2;

        System.out.println(root1);
        System.out.println(root2);
    }
}

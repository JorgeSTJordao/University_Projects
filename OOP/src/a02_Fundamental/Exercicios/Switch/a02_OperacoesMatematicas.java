package a02_Fundamental.Exercicios.Switch;

import java.util.Locale;
import java.util.Scanner;

public class a02_OperacoesMatematicas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        System.out.print("Digite o primeiro operando: ");
        float operador1 = input.nextFloat();

        System.out.print("Digite o segundo operando: ");
        float operador2 = input.nextFloat();

        System.out.println(
                "1. Adição \n" +
                "2. Subtração \n" +
                "3. Multiplicação \n" +
                "4. Divisão \n"
        );

        System.out.print("Digite a sua escolha: ");
        int escolha = input.nextInt();

        System.out.print("Resultado: ");
        switch (escolha){
            case 1:
                System.out.println(operador1 + operador2);
                break;
            case 2:
                System.out.println(operador1 - operador2);
                break;
            case 3:
                System.out.println(operador1 * operador2);
                break;
            case 4:
                System.out.println(operador1 / operador2);
                break;
            default:
                System.out.println("Digite apenas um dos valores listados");
        }
    }
}

package a02_Fundamental.Exercicios.Decisoes;

import java.util.Scanner;
import java.util.Locale;

public class a02_MenorNumero3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        System.out.print("Digite o valor de a: ");
        float a = input.nextFloat();

        System.out.print("Digite o valor de b: ");
        float b = input.nextFloat();

        System.out.print("Digite o valor de c: ");
        float c = input.nextFloat();

        if (a > b || a > c){
            if (b > c){
                System.out.printf("O valor de %s é o menor", c);
            } else {
                System.out.printf("O valor de %s é o menor", b);
            }
        }else{
            System.out.printf("O valor de %s é o menor", a);
        }
    }
}

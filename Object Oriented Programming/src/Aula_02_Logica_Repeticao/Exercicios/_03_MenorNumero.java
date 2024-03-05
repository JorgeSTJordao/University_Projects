package Aula_02_Logica_Repeticao.Exercicios;

import java.util.Scanner;
import java.util.Locale;

public class _03_MenorNumero {
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
                float menor = c;
                System.out.printf("O valor de %s é o menor", menor);
            } else {
                float menor = b;
                System.out.printf("O valor de %s é o menor", menor);
            }
        }else{
            float menor = a;
            System.out.printf("O valor de %s é o menor", menor);
        }
    }
}

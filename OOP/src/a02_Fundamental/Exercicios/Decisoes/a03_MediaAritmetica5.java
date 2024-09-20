package a02_Fundamental.Exercicios.Decisoes;

import java.util.Locale;
import java.util.Scanner;

public class a03_MediaAritmetica5{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        System.out.print("Digite o tamanho da amostra: ");
        int n = input.nextInt();

        System.out.print("Digite o valor de x1: ");
        float x1 = input.nextFloat();

        System.out.print("Digite o valor de x2: ");
        float x2 = input.nextFloat();

        System.out.print("Digite o valor de x3: ");
        float x3 = input.nextFloat();

        float x4 = 0f;
        float x5 = 0f;



        if (n == 5){
            System.out.print("Digite o valor de x4: ");
            x4 = input.nextFloat();

            System.out.print("Digite o valor de x5: ");
            x5 = input.nextFloat();
        }
        else if(n == 4){
            System.out.print("Digite o valor de x4: ");
            x4 = input.nextFloat();
        }

        x1 += x2 + x3 + x4 + x5;
        System.out.println((x1/5));
    }
}

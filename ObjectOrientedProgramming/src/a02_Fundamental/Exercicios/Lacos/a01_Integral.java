package a02_Fundamental.Exercicios.Lacos;

import java.util.Scanner;
import java.util.Locale;

public class a01_Integral {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        //Valor mínimo
        System.out.print("Digite o valor mínimo: ");
        float min = input.nextFloat();

        //Valor máximo
        System.out.print("Digite o valor de máximo: ");
        float max = input.nextFloat();

        //Validando a condição
        double area_total = 0;

        if (min < max) {
            System.out.print("Digite o nº de repetições: ");
            int n = input.nextInt();

            if (n > 0) {
                //Área inicial
                area_total = 0;

                //Valor inicial de X
                float x = min;

                //Valor de altura em cada trapézio (unidade) do gráfico
                float altura = (max - min) / n;

                //Repetição inicial
                int i = 0;

                //Valor inicial da coordenada (x1, y1)
                double y1 = 2 * Math.sin(x) + Math.cos(x) / 3;

                while (i < n) {
                    x = x + altura;

                    //Próxima coordenada (x2, y2)
                    double y2 = 2 * Math.sin(x) + Math.cos(x) / 3;

                    double area_trapezio = ((y1 + y2) / 2) * altura;

                    area_total += area_trapezio;

                    //O próximo valor de y1 será atribuído com base no valor da função de y2
                    y1 = y2;

                    i += 1;
                }
            } else {
                System.out.println("Erro: digite um valor superior a 1 para cálculo de área");
            }

        } else {
            System.out.println("Erro: o valor de mínimo não deve ser maior que o máximo");
        }

        System.out.printf("O valor total da área é %s", area_total);
    }

}

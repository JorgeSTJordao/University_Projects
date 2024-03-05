package a02_Fundamental.Exercicios.Lacos;

import java.util.Scanner;
import java.util.Locale;


public class a02_Projetil {


    public static void main(String[] args) {
        final float g = 9.8f;

        Locale.setDefault(Locale.US);


        Scanner input = new Scanner(System.in);


        System.out.print("Digite o valor da distância: ");
        float s = input.nextFloat();

        System.out.print("Digite o valor do ângulo: ");
        float teta = input.nextFloat();

        double v0 = Math.sqrt((200*g)/(2*Math.sin(teta)*2*Math.cos(teta))) ;

        double t = (2*v0*Math.sin(teta))/g;

        for (double ti = 0.1; ti < t; t+=0.1){

            double x0 = v0*Math.cos(teta)*ti;
            double y0 = v0*Math.sin(teta)*ti - (g*Math.pow(t, 2))/2;

            System.out.print("t = %: (%, %d)".format(ti, x0, y0));
        }
    }
}

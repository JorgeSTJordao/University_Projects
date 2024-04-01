package a02_Fundamental.Exercicios.Lacos;

import java.util.Scanner;
import java.util.Locale;

public class a02_Projetil {

    //O(1)
    public static void main(String[] args) {
        final float g = 9.8f;

        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor da distância: ");
        float s = input.nextFloat();

        System.out.print("Digite o valor do ângulo: ");
        float teta = input.nextFloat();


        //Velocidade inicial
        double v0 = Math.sqrt((s*g)/(2*Math.sin(Math.toRadians(teta))*Math.cos(Math.toRadians(teta))));

        //Tempo total
        double tempoTotal = 2*v0*Math.sin(Math.toRadians(teta))/g;

        System.out.println("Velocidade inicial = " + v0 + " m/s");
        System.out.println("Tempo total = " + tempoTotal + "s");

        //O(T)
        //A iteração permanece até o valor de t (tempo atual) ser igual ao tempo total (T)
        for (double t = 0.1; t <= tempoTotal; t+=0.1){

            double x0 = v0*Math.cos(Math.toRadians(teta))*t;
            double y0 = v0*Math.sin(Math.toRadians(teta))*t - (g*Math.pow(t, 2))/2;

            System.out.println(String.format("t = %s: (%s, %s)", t, x0, y0));
        }
    }
}

package a04_Char;

import java.util.Scanner;

public class a03_tabela_ascii {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Alfabeto
        System.out.println("Alfabeto minúsuculo");
        char valor = 'a';
        for (int i = 0; i < 25; i++) {
            valor++;
            System.out.printf("%s ", valor);
        }
        System.out.println("| Terminou");
        System.out.print("\n");

        //Alfabeto utilizando letras e não índice
        System.out.println("Alfabeto maiúsculo");
        for (char c = 'A'; c <= 'Z'; c++)
            System.out.printf("%s ", c);
        System.out.println("| Terminou");
        System.out.print("\n");

        //Posição na tabela ASCII
        valor = 'a';
        System.out.println(valor + 4);
        System.out.print("\n");

        //Distância entre letras
        System.out.println("Distância");
        int distancia = 'b' - 'a';
        System.out.println(distancia);
    }
}

package a03_Strings_Classes_Estaticas.Exercicios;

import java.util.Scanner;

public class a02_LexicografiaI {
    public static void main(String[] args) {

        /*
         O código irá tratar a lexicografia de strings, considerando que eles devem estar em ordem alfabética

         Ambos os valores de entrada devem receber uma string

         - A comparação será feito por meio do método compareTo
         */

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a primeira string: ");
        String s1 = input.nextLine();

        System.out.printf("%s \n", s1);

        System.out.print("Digite a segunda string: ");
        String s2 = input.nextLine();

        System.out.printf("%s \n", s2);


        System.out.println("Strings em ordem lexicográfica: ");
        System.out.println("---------------------");

        if (s1.compareTo(s2) < 0){
            System.out.println(s1);
            System.out.println(s2);
        } else {
            System.out.println(s2);
            System.out.println(s1);
        }
    }
}

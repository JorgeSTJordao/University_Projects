package a03_Strings_Classes_Estaticas;

import java.util.Scanner;

public class a03_readString {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite uma string qualquer: ");
        String frase = teclado.nextLine();
        System.out.println(frase);

        System.out.print("Digite uma outra string: ");
        String palavra = teclado.next();
        System.out.println(palavra);
    }
}

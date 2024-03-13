package a04_Char;

import java.util.Scanner;

public class a01_declaracao {
    public static void main(String[] args) {
        //Tamanho de Char
        System.out.printf("Char Size: %d b \n", Integer.BYTES*8*2);

        //Pergunta
        System.out.print("Digite uma palavra: ");
        Scanner input = new Scanner(System.in);
        char firstCharWord = input.next().charAt(0);

        //Declaração
        char letra = 'J';
        char simbolo = '@';
        char letra_maiuscula = 'L';

        //Out:
        System.out.printf(
                "Letra: %s " +
                "| Símbolo: %s " +
                "| Letra Maiúscula: %s" +
                "| Char de Input: %s"
                ,letra, simbolo, letra_maiuscula, firstCharWord);

    }
}

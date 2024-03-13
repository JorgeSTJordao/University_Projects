package a04_Char.Exercicios;

import java.util.Scanner;

public class a01_contarVogaisEConsoantes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String charWord = input.next().toLowerCase();

        int totalVogais = 0;
        int totalOutros = 0;

        for (int i = 0; i < charWord.length(); i++){
            char letra = charWord.charAt(i);
            if(letra == 'a' || letra == 'e'  || letra == 'i' || letra == 'o' || letra == 'u')
                totalVogais+=1;
            else if (letra < 'a' || letra > 'z')
                totalOutros += 1;
        }
        System.out.printf("Existem %d vogais, %d caratereres epeciais e %d consoantes",
                totalVogais,
                totalOutros,
                (charWord.length() - (totalVogais + totalOutros)));
    }
}

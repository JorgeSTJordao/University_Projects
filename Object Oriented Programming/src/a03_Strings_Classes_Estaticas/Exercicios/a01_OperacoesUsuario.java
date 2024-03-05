package a03_Strings_Classes_Estaticas.Exercicios;

import java.util.Scanner;

public class a01_OperacoesUsuario {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma string qualquer: ");
        String stringValue = input.nextLine();

        System.out.println("String maiúscula: " + stringValue.toUpperCase());
        System.out.println("String minúscula: " + stringValue.toLowerCase());
        System.out.println("Subtring (3 primeiros caracteres): " + stringValue.substring(0, 3));

        System.out.println("-------------");

        System.out.print("Digite uma parte da string: ");
        String stringPart = input.nextLine();

        if (stringValue.contains(stringPart)){
            System.out.printf(
                    "Substring digitada: %s | Índice inicial: %d",
                    stringValue.contains(stringPart), stringValue.indexOf(stringPart));
        } else {
            System.out.println("Subtring não encontrada");
        }

        System.out.println("\n-------------");

        System.out.print("Digite uma string qualquer: ");
        String stringValue1 = input.nextLine().toLowerCase();

        System.out.print("Digite uma outra string: ");
        String stringValue2 = input.nextLine().toLowerCase();

        if (stringValue1.equals(stringValue2)){
            System.out.println("Ambas as strings são iguais");
        } else {
            System.out.println("Strings distintas");
        }

    }
}

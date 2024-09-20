package a04_Char;

import java.util.Scanner;

public class a02_switch_case {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma letra qualquer ou palavra: ");
        char valor = input.next().charAt(0);

        switch (valor){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("Vogal");
                break;
            default:
                System.out.println("Consoante");
        }


        //Somando um caracter, mostrando a próxima letra

    }
}

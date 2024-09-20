package a05_Array_Classes.Exercicios.arrays;

import java.util.Scanner;

public class a01_frequencia_vogais {

    public static char[] armazenarChar(int n, char[] caracteres, Scanner input){

        for (int i = 0; i < caracteres.length; i++) {
            System.out.println("Digite um caractere: ");
            caracteres[i] = input.next().trim().charAt(0);

            if (Character.isDigit(caracteres[i])){
                n -= 1;
            }
        }

        char[] caracteresFiltrados = new char[n];
        int i = 0;

        for (char caracter: caracteres) {
            if (!Character.isDigit(caracter)) {
                caracteresFiltrados[i] = caracter;
                i += 1;
            }
        }
        return caracteresFiltrados;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Quantos caracteres deseja inserir? ");
        int n = input.nextInt();

        char[] caracteres = new char[n];

        char[] caracteresArray = armazenarChar(n, caracteres, input);

        n = 0;

        for (char caracter: caracteresArray){
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u')
                n += 1;
        }

        System.out.println(caracteresArray);
        System.out.printf("Existem %d porcento de vogais em relação ao nº de letras no total", 100*n/caracteresArray.length);
    }
}

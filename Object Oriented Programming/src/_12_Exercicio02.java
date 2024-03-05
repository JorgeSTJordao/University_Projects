import java.util.Scanner;

public class _12_Exercicio02 {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);

        System.out.print("Digite o valor da razão: \t");
        int r = input1.nextInt();

        System.out.print("Digite o índice do valor que procura: \t");
        int n = input2.nextInt();

        System.out.print("Digite o primeiro valor da progressão: \t");
        int a1 = input3.nextInt();

        int an = a1 + (n - 1)*r;
        System.out.println("O valor de an é: " + an);
    }
}

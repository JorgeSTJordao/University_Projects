import java.util.Scanner;

public class _05_ConditionalsAndLoops {
    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        int number1 = input1.nextInt();

        System.out.println("Digite outro valor: ");
        int number2 = input2.nextInt();

        if (number1 > number2){
            System.out.println("O valor " + number1 + " é maior que " + number2);
        } else {
            System.out.println("O valor " + number1 + " não é maior que " + number2);
        }
    }
}

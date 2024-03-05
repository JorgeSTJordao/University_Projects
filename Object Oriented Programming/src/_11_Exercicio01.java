import java.util.Locale;
import java.util.Scanner;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class _11_Exercicio01 {
    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);

        System.out.print("Digite o valor do raio:\t");
        input1.useLocale(Locale.US);
        double r = input1.nextDouble();
        System.out.println("A área do círculo é: " + (PI * pow(r, 2)));
    }
}

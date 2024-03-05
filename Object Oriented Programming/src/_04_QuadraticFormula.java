//Help stackoverflow
//https://stackoverflow.com/questions/72376431/java-lang-numberformatexception-for-input-string-5-3

// O public significa que um método ou classe é acessível para todos os outros objetos

import java.lang.Math;

public class _04_QuadraticFormula {
    public static void main(String[] args) {
        double b = -3.0;
        double c = 2.0;

        double delta_sqrt = Math.sqrt(Math.pow(b, 2) - 4.0*c);

        double root1 = (-b + delta_sqrt)/2;
        double root2 = (-b - delta_sqrt)/2;

        System.out.println(root1);
        System.out.println(root2);

    }
}

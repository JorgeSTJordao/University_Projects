package a01_Inicio;

// y = 5*x + n

public class a02_TiposNumericos {
    public static void main(String[] args) {

        //Máximos e mínimos de um tipo
        System.out.println("CASO 1");
        System.out.println("Valor máximo: " + Short.MAX_VALUE);

        short valor = Short.MAX_VALUE;

        valor++;
        System.out.println("Valor atual: " + valor);

        //Função afim
        System.out.println("\nCASO 2");

        int x = 2;
        int n = 5;

        int y = 5*x * n;

        System.out.println("Y = " + y);

        //Convertendo um valor inteiro para short
        System.out.println("\nCASO 3");

        x = Short.MAX_VALUE;
        y = 5*(short) x + (short) n;
        System.out.println("Y = " + y);

        //Tipo flutuante
        System.out.println("\nCASO 4");

        float w = 3.14f;
        System.out.println("W = " + w);

        System.out.println("\nCASO 5");
        //Flutuante com double
        //Converte um tipo menor para maior não é possível
        double z = 8.0;
        double u = w * z;
        System.out.println("U = " + u);

        System.out.println("\nCASO 6");
        //Trabalhando com valores de double (E = 10**n)
        u = 1E+40;
        System.out.println("U = " + u);
        System.out.println("U = " + ((float) u));
        System.out.println((float) u == u);
    }
}



package a03_Strings_Classes_Estaticas;


class SomatoriaCoordenadas{
    private static double tx = 0;

    private static double polinomio(double x){
        tx += x;

        final int a=3, b=-8, c=1, d=4;

        return (a*Math.pow(x, 3) + b*Math.pow(x, 2) + c*x + d);
    }

    public static void main(String[] args) {
        double ty = 0;

        for (double x = 0; x <= 4; x++){
            double y = polinomio(x);
            ty += y;
            System.out.println("(" + x + ", " + y + ")");
        }

        System.out.println("tx= " + tx);
        System.out.println("ty= " + ty);
    }
}

public class a05_somatoriaCoordenadas {

}

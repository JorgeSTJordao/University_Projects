package a01_Inicio;

public class ConversoesdeTipos {
    public static void main(String[] args) {

        // 1th part
        short k1 = 32767;
        System.out.println("k1 " + k1);
        k1++;
        System.out.println("k1 " + k1);

        // 2nd part
        int k2 = 2;
        int k21 = 5;

        int k22 = k2 * k21 - 3;
        int k23 = k2 * k21 - k22*20;

        // 3rd part
        int k3 = 32767;
        short k31 = (short) k3;
        System.out.println("k3 " + k3);
        System.out.println("k31 " + k31);

        //4th part
        Float k4 = 3.14f;
        System.out.println("k4 " + k4);

        //5th part
        float k5 = 3.5f;
        double k51 = 8.0;
        double k52 = k5 * k51;
        System.out.println("k52 " + k52);

        //6th part
        double k6 = 1E+40;
        System.out.println("k6 " + k6);
        float k61 = (float) k6;
        System.out.println("k61 " + k61);

        //7th
        final float k7 = 1 + 2;
        System.out.println("k7 " + k7);
    }
}

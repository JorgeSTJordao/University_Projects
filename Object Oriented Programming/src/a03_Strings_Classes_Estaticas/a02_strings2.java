package a03_Strings_Classes_Estaticas;

public class a02_strings2 {

    static void repetir() {
        for (int i = 0; i < 15; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        //CONCATENÇÃO - PARTE 1
        String s1 = new String("Pimenta");
        String s2 = new String("Rosa");
        String s3 = s1 + s2;

        System.out.println(s3);
        String s4 = s1.concat(s2);
        System.out.println(s4);

        repetir();

        //CONCATENÇÃO - PARTE 2
        String s5 = s1 + " " + s2;

        System.out.println(s5);

        String s6 = s5 + 10;
        System.out.println(s6);
        String s7 = s5 + 10 + 20;

        System.out.println(s7);
        System.out.println(s7);

        String s8 = s5 + (10 + 20);
        System.out.println(s8);
    }
}

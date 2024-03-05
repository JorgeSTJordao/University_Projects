package a03_Strings_Classes_Estaticas;

public class a04_stringsFormat {

    public static void main(String[] args) {
        String s;

        //%d para valores decimais
        s = String.format("inteiro decimal: %d", 45);
        System.out.println(s);

        //%f para valores flutuantes
        s = String.format("real: %f", 4.6758);
        System.out.println(s);

        //%<numero>d
        s = String.format("inteiro decimal: %8d", 45);
        System.out.println(s);

        s = String.format("real: %6.2f", 4.523);
        System.out.println(s);
    }
}

package a03_Strings_Classes_Estaticas;

public class a04_stringsFormat {

    public static void main(String[] args) {
        String s;

        //%d para valores inteiros
        s = String.format("inteiro decimal: %d", 45);
        System.out.println(s);

        //%f para valores flutuantes
        s = String.format("real: %f", 4.6758);
        System.out.println(s);

        //Mostra 8 casas dos números acima de 0, considerando que as duas primeiras são
        //ocupadas pelo valor 45
        s = String.format("inteiro decimal: %8d", 45);
        System.out.println(s);

        s = String.format("real: %06.2f", 4.523);
        System.out.println(s);
    }
}

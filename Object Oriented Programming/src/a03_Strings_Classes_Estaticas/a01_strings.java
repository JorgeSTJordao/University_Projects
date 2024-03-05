package a03_Strings_Classes_Estaticas;


public class a01_strings {
    static void repetir(){
        for (int i=0; i < 15; i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        //Garbage collect
        //Criação explícita de um objeto String
        String frase = new String("Mas eis chega a roda-viva");
        System.out.println(frase);

        //CONCATENÇÃO
        System.out.println("|" + frase+"|");

        String frase_limpa = frase.trim();

        System.out.println("|" + frase_limpa + "|");

        frase = frase_limpa;

        repetir();

        //COMPARAÇÃO COM LETRA MAIÚSCULA
        String frase_maiusculo = frase.toUpperCase();

        System.out.println(("|" + frase_maiusculo + "|"));

        System.out.println(frase_maiusculo.length());

        System.out.println(frase.equals(frase_maiusculo));

        System.out.println(frase.equalsIgnoreCase(frase_maiusculo));

        //SUBSTRING E ÍNDICE
        repetir();

        String parte_da_frase = frase.substring(10, 20);

        System.out.println(parte_da_frase);

        System.out.println(frase.contains("roda-viva"));

        System.out.println(frase.indexOf("che"));

        System.out.println(frase.indexOf("computador"));

    }
}

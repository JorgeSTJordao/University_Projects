package a03_Strings_Classes_Estaticas;

import java.util.List;

public class StringsMethods {
    public static void main(String[] args) {
        String dado = new String("   Va_lor");

        //isBlack (É vazia (espaços em branco possuem espaço))
        System.out.println(dado.isEmpty());

        //split (separar a String)
        //https://www.javatpoint.com/java-string-format
        String[] result = dado.split("_");
        for (String word : result) {
            System.out.printf("%s ", word);
        }
        System.out.print("\n");

        //trim (elimina espaços em branco)
        System.out.println(dado.trim());

        //concat (juntar)
        String dadoAux = new String("Va_lor ");
        System.out.println(dado.concat(dadoAux).trim());
    }
}

package RA1_Training;

public class a2_Q2 {

    //Constantes
    private static char[] letra_x = { 'A', 'C', 'G', 'T' };
    private static char[] letra_y = { 'R', 'B', 'Z', 'M' };


    //Codificar um char
    private static char codificar(char letra)
    {
        //O char iremos saber
        char resposta = '?';
        //Valor encontrado
        boolean encontrado = false;
        int i = 0;

        //Verifica todos os caracteres de X
        while (!encontrado && i < letra_x.length)
        {
            //Se uma letra da String corresponder a uma dos caracteres de X, o valor será dado como encontrado
            if (letra == letra_x[i])
            {
                encontrado = true;
                //Atribuir a letra de X para a de Y
                resposta = letra_y[i];
            }
            else i++;
        }
        return resposta;
    }


    //Fazer a codificação por partes
    private static String codificar(String palavra)
    {
        //A resposta codificada não tem nada ainda
        String resposta = "";

        //Irá percorrer até chegar a última letra
        for (int i = 0; i < palavra.length(); i++)
        {
            //O char entregue será dado pela função codificar com Char
            char c = palavra.charAt(i); // i-ésima letra da palavra

            //União das letras para codificar
            resposta = resposta + codificar(c);
        }
        //Resposta codificada
        return resposta;
    }

    public static void main(String[] args) {
        //A função irá codificar uma String
        System.out.println(codificar("TACGAACTAG"));
        System.out.println(codificar("GATMAKETGX"));
    }
}

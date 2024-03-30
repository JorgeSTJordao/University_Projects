package RA1_Training;

public class a1_Q1 {

    private static double f(double x, int k){

        //Verifica se o valor inteiro não é inferior a 0
        if (k < 0) k = -k; //Inverte o sinal caso seja

        //Loop
        //Entrega um valor negativo (k > 2) || positivo (k == 1)
        for (int i = 0; i < k; i++){
            //O índice é par?
            if (i % 2 == 0)
                x = x/2;
            //Ou é ímpar
            else
                x = -x/2;
        }

        return x;
    }
    public static void main(String[] args) {
        //Dividir os números por dois a partir de determinadas condições
        System.out.println(f(256, 6));
        System.out.println(f(-60.8, -4));
    }
}


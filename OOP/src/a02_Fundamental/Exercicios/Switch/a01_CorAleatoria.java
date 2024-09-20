package a02_Fundamental.Exercicios.Switch;

public class a01_CorAleatoria {
    public static void main(String[] args) {
        //
        int distance = 10;
        int min = 0;
        //10 + 5 = 15 | (5 <= .. < 15)
        //[5..14]
        int rand = (int)(Math.random() * distance) + min;

        System.out.println("O nº sorteado foi " + rand);

        switch (rand){
            case 0:
            case 1:
            case 2:
                System.out.println("Azul");
                break;
            case 5:
            case 7:
            case 9:
                System.out.println("Marrom");
                break;
            default:
                System.out.println("Amarelo");
        }

    }
}

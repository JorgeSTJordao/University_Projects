package a05_Array_Classes.Exercicios.XUber;

public class Xuber {
    private static float MAX_X = 20;
    private static float MAX_Y = 10;
    private static final int INTERVALO_PADRAO = 1200; // tempo em segundos entre atualizações da posição
    private static final int FATOR_SIMULACAO = 60; // redução na escala do tempo de simulação

    public static void main(String[] args)
    {
        Carro carro_A = new Carro();
        Carro carro_B = new Carro();
        Carro carro_C = new Carro();

        carro_A.definir_numero(5);
        carro_B.definir_numero(8);
        carro_C.definir_numero(2);

        int iteracao = 1;
        do {
            System.out.println("\n============================================ ITERAÇÃO " + iteracao);

            carro_A.atualizar_coordenadas( x(), y() );
            carro_B.atualizar_coordenadas( x(), y() );
            carro_C.atualizar_coordenadas( x(), y() );

            carro_A.exibir();
            carro_B.exibir();
            carro_C.exibir();

            float destino_x = x();
            float destino_y = y();
            System.out.println(String.format("Tempo em segundos para chegar no destino (%.2f; %.2f)",
                    destino_x, destino_y));
            System.out.println("Carro " + carro_A.numero() + ": " +
                    carro_A.estimar_tempo(destino_x, destino_y));
            System.out.println("Carro " + carro_B.numero() + ": " +
                    carro_B.estimar_tempo(destino_x, destino_y));
            System.out.println("Carro " + carro_C.numero() + ": " +
                    carro_C.estimar_tempo(destino_x, destino_y));

            aguardar_intervalo_padrao();
            iteracao++;
        } while (true);
    }

    private static float x()
    {
        double aleatorio = Math.random(); // valor entre 0 e 1
        float valor_x = (float) aleatorio * MAX_X;
        return valor_x;
    }

    private static float y()
    {
        double aleatorio = Math.random(); // valor entre 0 e 1
        float valor_y = (float) aleatorio * MAX_Y;
        return valor_y;
    }

    private static void aguardar_intervalo_padrao()
    {
        try { Thread.sleep(INTERVALO_PADRAO * 1000 / FATOR_SIMULACAO); }
        catch (Exception e) {}
    }
}
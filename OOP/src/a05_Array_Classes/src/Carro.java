package a05_Array_Classes.src;

public class Carro {
    private int numero;
    private float velocidade =  0;
    private char direcao = 'L'; // ideal: L ou N, com 50% de chance para cada um
    private float coordenada_x = 0;
    private float coordenada_y = 0;
    private static final int INTERVALO_PADRAO = 1200; // tempo em segundos entre atualizações da posição

    private void atualizar_velocidade(float x, float y)
    {
        float delta_x = Math.abs(x - coordenada_x);
        float delta_y = Math.abs(y - coordenada_y);
        float distancia_percorrida = delta_x + delta_y;
        velocidade = (distancia_percorrida / INTERVALO_PADRAO) * 3600; // 1 hora == 3600 segundos
    }
    private void atualizar_direcao(float x, float y)
    {
        switch( direcao )
        {
            case 'L' :
            case 'O':
                if (y < coordenada_y) direcao = 'S';
                else if (y > coordenada_y) direcao = 'N';
                break;
            case 'N':
            case 'S':
                if (x < coordenada_x) direcao = 'O';
                else if (x > coordenada_x) direcao = 'L';
        }
    }
    public void atualizar_coordenadas(float x, float y)
    {
        atualizar_velocidade(x, y);
        atualizar_direcao(x, y);
        coordenada_x = x;
        coordenada_y = y;
    }
    public int estimar_tempo(float x, float y)
    {
        int tempo_estimado = 0; // em segundos
        float delta_x = Math.abs(x - coordenada_x);
        float delta_y = Math.abs(y - coordenada_y);
        float distancia_a_percorrer = delta_x + delta_y;
        tempo_estimado = (int) (distancia_a_percorrer / velocidade * 3600);
        return tempo_estimado;
    }
    public void definir_numero(int n)
    {
        numero = n;
    }
    public int numero()
    {
        return numero;
    }
    public void exibir()
    {
        System.out.println("Carro " + numero + ":");
        System.out.println(String.format("Coordenadas atuais: (%.2f; %.2f)", coordenada_x, coordenada_y));
        System.out.println(String.format("Velocidade: %.2f Km/h", velocidade));
        System.out.println("Direção: " + direcao);
        System.out.println("---------------------------------------------");
    }
}
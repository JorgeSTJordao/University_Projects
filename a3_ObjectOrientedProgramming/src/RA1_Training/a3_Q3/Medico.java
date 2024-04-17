package RA1_Training.a3_Q3;

public class Medico {
    private String nome;
    private double ganho;
    private Enfermeiro assistente1;
    private Enfermeiro assistente2;

    public Medico(String nome) {
        this.nome = nome;
        ganho = 0;
    }

    public void incluir_assistente(Enfermeiro enfermeiro) {
        if (assistente1 == null)
            assistente1 = enfermeiro;
        else if (assistente2 == null)
            assistente2 = enfermeiro;
    }

    public void ganhar(double valor) {
        if (assistente1 != null) {
            assistente1.ganhar(0.1 * valor);
            valor = 0.9 * valor;
        }
        if (assistente2 != null) {
            assistente2.ganhar(0.1 * valor);
            valor = 0.8 * valor;
        }
        ganho = ganho + valor;
    }

    public double resultado() {
        return ganho;

    }
}

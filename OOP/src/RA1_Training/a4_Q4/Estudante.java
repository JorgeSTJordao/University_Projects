package RA1_Training.a4_Q4;

public class Estudante {
    private String nome;
    private double nota;
    public Estudante(String nome)
    {
        this.nome = nome;
        nota = 0;
    }
    public boolean is(String nome_procurado)
    {
        return (nome.equals(nome_procurado));
    }
    public void atribuir_nota(double nota)
    {
        this.nota = nota;
    }
    public String resultado()
    {
        String res = nome + "(" + nota + ")" + ": ";
        if (nota >= 7)
            res += "APROVADO";

        else
            if (nota < 4)
                res += "REPROVADO";
            else
                res += "RECUPERAÇÃO";

        return res;
    }
}

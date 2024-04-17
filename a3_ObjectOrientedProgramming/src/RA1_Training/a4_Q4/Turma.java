package RA1_Training.a4_Q4;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private ArrayList<Estudante> alunos;
    public Turma(String nome)
    {
        this.nome = nome;
        alunos = new ArrayList<Estudante>();
    }
    public void inserir(Estudante e)
    {
        alunos.add(e);
    }
    public void atribuir_nota(String nome_estudante, double nota)
    {
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < alunos.size())
        {
            Estudante x = alunos.get(i);
            if (x.is(nome_estudante))
            {
                x.atribuir_nota(nota);
                encontrado = true;
            }
            else
            {
                i += 1;
            }
        }
    }
    public void resultado()
    {
        System.out.println("Resultado da Turma " + nome + ":");
        for (Estudante e : alunos)
        {
            System.out.println(e.resultado());
        }
        System.out.println();
    }

}

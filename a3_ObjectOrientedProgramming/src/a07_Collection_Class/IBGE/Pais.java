package a07_Collection_Class.IBGE;

import java.util.ArrayList;

public class Pais {

    //Estados
    ArrayList<Estado> estados = new ArrayList<>();

    //Nome
    String nome;

    //População de todos os estados
    int populacaoTotalEstados;

    //Área total de todos os estados
    double areaTotalEstados;

    public Pais(String nome){
        this.nome = nome;
        populacaoTotalEstados = 0;
        areaTotalEstados = 0;
    }

    public void adicionarEstado(Estado estado){
        estados.add(estado);
        populacaoTotalEstados += populacao(estado);
        areaTotalEstados += area(estado);
    }

    int populacao(Estado estado)
    { return estado.populacaoTotalMunicipios; }
    double area(Estado estado)
    { return estado.areaTotalMunicipios; }
    double densidade() {
        return populacaoTotalEstados/ areaTotalEstados;
    }

    public int menorPopulacaoEstado(){
        int menorPopulacao = estados.get(0).populacaoTotalMunicipios;
        for (Estado estado : estados){
            if (estado.populacaoTotalMunicipios < menorPopulacao){
                menorPopulacao = estado.populacaoTotalMunicipios;
            }
        }
        return menorPopulacao;
    }
}

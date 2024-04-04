package a07_Collection_Class.IBGE;

import java.util.ArrayList;

public class Estado {

    ArrayList<Municipio> municipiosEstado = new ArrayList<>();

    String nome;

    int populacaoTotalMunicipios;

    //Área total de todos os estados
    double areaTotalMunicipios;

    public Estado(String nome){

        //Característica do estado
        this.nome = nome;
        populacaoTotalMunicipios = 0;
        areaTotalMunicipios = 0;
    }

    //Municípios
    public void adicionarMunicipio(Municipio municipio){
        municipiosEstado.add(municipio);
        populacaoTotalMunicipios += populacao(municipio);
        areaTotalMunicipios += area(municipio);
    }

    //Adicionar população
    public int populacao(Municipio municipio)
    {
        return municipio.populacao();
    }


    //Adicionar área
    public double area(Municipio municipio)
    {
        return municipio.area();
    }

    //Verificar densidade
    double densidade() { return populacaoTotalMunicipios / areaTotalMunicipios; }

    public int menorPopulacaoMunicipios(){
        int menorPopulacao = municipiosEstado.get(0).populacao;
        for (Municipio municipio : municipiosEstado){
            if (municipio.populacao < menorPopulacao){
                menorPopulacao = municipio.populacao;
            }
        }
        return menorPopulacao;
    }
}

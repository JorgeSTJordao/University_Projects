package a07_Collection_Class.IBGE;

public class Municipio {

    final String nome;

    int populacao;

    private final double area;

    public Municipio(String nome, int populacao, double area) {
        this.nome = nome;
        this.populacao = populacao;
        this.area = area;
    }

    public String nome(){
        return nome;
    }
    public int populacao() {
        return populacao;
    }

    public double area() {
        return area;
    }

    public double densidade() {
        return populacao / area;
    }
}


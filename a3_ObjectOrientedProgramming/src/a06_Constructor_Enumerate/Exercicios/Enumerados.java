package a06_Constructor_Enumerate.Exercicios;

//Enumerate segue a mesma ideia de uma classe

class Loja{}

class Camiseta{
    String marca;

    enum Modelo {TRADICIONAL, REGATA, GOLA_V;

    }
    enum Tamanho {PEQUENO, MEDIO, GRANDE, EXTRA_GRANDE}

    enum Cor {BRANCA, PRETA, AZUL, AMARELA}

    Float preco;

    Integer estoque;

    public void getDados(String marca,
                    String modelo,
                    String tamanho,
                    String cor,
                    Float preco,
                    Integer estoque){
        this.marca = marca;

        this.preco = preco;
        this.estoque = estoque;
    }
}

public class Enumerados {
    public static void main(String[] args) {
        Camiseta camiseta1;
    }
}

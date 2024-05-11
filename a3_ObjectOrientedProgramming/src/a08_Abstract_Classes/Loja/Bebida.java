package a08_Abstract_Classes.Loja;

abstract class Bebida {
    String nomeFabricante;
    private int precoUnitario;

    private int estoque;

    public Bebida(String nomeFabricante, int precoUnitario, int estoque){
        this.nomeFabricante = nomeFabricante;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
    }
}

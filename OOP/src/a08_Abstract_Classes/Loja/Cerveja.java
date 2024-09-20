package a08_Abstract_Classes.Loja;

public class Cerveja extends Bebida{

    private String nomeFabricante;
    private int precoUnitario;
    private int estoque;

    public Cerveja(String nomeFabricante, int precoUnitario, int estoque) {
        super(nomeFabricante, precoUnitario, estoque);

        this.nomeFabricante = nomeFabricante;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
    }


}

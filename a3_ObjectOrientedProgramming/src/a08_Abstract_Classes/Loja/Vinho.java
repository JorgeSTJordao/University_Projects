package a08_Abstract_Classes.Loja;

public class Vinho extends Bebida{

    //Atributos da super classe
    private String nomeFabricante;
    private int precoUnitario;
    private int estoque;

    //Atributos da classe
    private int anoFabricacao;

    private String paisOrigem;

    private CorVinho cor;

    private String tipoUva;


    public Vinho(
            String nomeFabricante,
            int precoUnitario,
            int estoque,
            String paisOrigem,
            CorVinho cor,
            String tipoUva) {

        super(nomeFabricante, precoUnitario, estoque);

        this.nomeFabricante = nomeFabricante;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
        this.paisOrigem = paisOrigem;
        this.cor = cor;
        this.tipoUva = tipoUva;
    }


}

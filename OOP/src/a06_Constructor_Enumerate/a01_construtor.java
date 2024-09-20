package a06_Constructor_Enumerate;


public class a01_construtor {

    public static class Pessoa{
        String nome;
        int idade;

        public Pessoa(
                String nome,
                int idade
        ){
            this.nome = nome;
            this.idade = idade;
        }

        public void outputAtributos(){
            System.out.printf("Nome: %s | Idade:%d", nome, idade);
        }
    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Pedro", 15);

    }
}

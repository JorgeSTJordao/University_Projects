package caleb_curruy_oop;


public class User {
    String nome = "None";
    String membro = "None";


    //Função de setter (construtor)
    public User(String nome, String membro){
        this.nome = nome;
        this.membro = membro;
    }

    public static String adicional(){
        return "| usario";
    }

     public String toString(){
        return nome + " " + membro + adicional();
     }

     public boolean igual(User u2){
        return nome.equals(u2.nome);
     }
}

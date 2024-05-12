package caleb_curruy_oop;

public class Student extends User{

    int sala;

    public Student(String nome, String membro, int sala) {
        super(nome, membro);
        this.nome = nome;
        this.membro = membro;
        this.sala = sala;
    }

}

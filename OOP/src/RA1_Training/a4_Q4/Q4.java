package RA1_Training.a4_Q4;

public class Q4 {
    public static void main(String[] args) {
        Turma A = new Turma("A");
        A.inserir(new Estudante("Rossum"));
        A.inserir(new Estudante("Goldberg"));
        A.inserir(new Estudante("Dahl"));
        A.inserir(new Estudante("Gosling"));
        Turma B = new Turma("B");
        B.inserir(new Estudante("Wirth"));
        B.inserir(new Estudante("Meyer"));
        B.inserir(new Estudante("Gamma"));
        B.inserir(new Estudante("Stroustrup"));
        A.atribuir_nota("Dahl", 8.0);
        A.atribuir_nota("Goldberg", 9.0);
        B.atribuir_nota("Gamma", 10.0);
        B.atribuir_nota("Meyer", 7.0);
        A.atribuir_nota("Gosling", 6.0);
        B.atribuir_nota("Wirth", 5.5);
        B.atribuir_nota("Stroustrup", 8.5);
        A.atribuir_nota("Rossum", 3.0);
        A.resultado();
        B.resultado();
    }
}

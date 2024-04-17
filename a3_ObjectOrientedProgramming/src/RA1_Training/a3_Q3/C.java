package RA1_Training.a3_Q3;

public class C {
    public static void main(String args[])
    {
        Medico alex = new Medico("Alexandre");
        Medico bea = new Medico("Beatriz");
        Medico marcos = new Medico("Marcos");
        Enfermeiro carlos = new Enfermeiro("Carlos");
        Enfermeiro telma = new Enfermeiro("Telma");
        Enfermeiro bruna = new Enfermeiro("Bruna");
        alex.incluir_assistente(carlos);
        alex.incluir_assistente(telma);
        alex.incluir_assistente(bruna);
        bea.incluir_assistente(telma);
        bea.incluir_assistente(bruna);
        marcos.incluir_assistente(bruna);
        alex.ganhar(1000.00);
        bea.ganhar(2000.00);
        marcos.ganhar(1000.00);
        System.out.println(alex.resultado());
        System.out.println(bea.resultado());
        System.out.println(marcos.resultado());
        System.out.println(carlos.resultado());
        System.out.println(telma.resultado());
        System.out.println(bruna.resultado());
    }
}

package free_code_camp_course.a01_hello_world;

public class Variables {
    static int idade = 20;

    //Métodos estáticos funcionam apenas com variáveis estáticas
    public static void main(String[] args) {
        //O compilador já entende que a variável existe
        int idade;
        idade = 25;

        System.out.println("Idade é " + 25 + " anos");
    }
}

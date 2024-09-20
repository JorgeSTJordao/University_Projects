package caleb_curruy_oop;

//1 - Introdução
//2 - Getters e Setters
//3 - Método Overloading
//4 - Construtores
//5 - Overriding
//6 - Generic List
//7 - Membros estáticos (acesso da classe sem ser necessariamente por um objeto)
//8 - Classes abstratas (não podem ter uma instância, mas uma subclasse)

import java.util.ArrayList;
import java.util.List;

public class OOP {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Criar uma classe chamada usuário
        //Aqui chamamos o construtor primário (instanciação)
        User u1 = new User();
        User u2 = new User();


        //Lista genérica
        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);

        System.out.println(users);

        for (User user : users) {
            System.out.println(user);
        }
    }
}

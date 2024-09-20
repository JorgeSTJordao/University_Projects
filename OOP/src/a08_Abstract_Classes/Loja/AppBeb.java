package a08_Abstract_Classes.Loja;

import java.util.ArrayList;
import java.util.Collection;

public class AppBeb {
    public static void main(String[] args) {
        new Cerveja("Pedro", 2, 25);

        Loja loja1 = new Loja("Nome1", new ArrayList<Bebida>());
    }
}

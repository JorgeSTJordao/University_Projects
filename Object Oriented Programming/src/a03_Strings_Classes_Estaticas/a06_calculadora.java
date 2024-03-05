package a03_Strings_Classes_Estaticas;

class Calculadora {
    public static double somar(double x, double y){
        return (x + y);
    }

    public static double subtrair(double x, double y){
        return (x - y);
    }

    public static double multiplicar(double x, double y){
        return (x*y);
    }

    public static double dividir(double x, double y){
        return (x/y);
    }
}

class TesteCalculadora{

    public static void main(String[] args) {
        System.out.println(Calculadora.somar(3.5, 6.5));
        System.out.println(Calculadora.subtrair(3.5, 6.5));
        System.out.println(Calculadora.multiplicar(3.5, 6.5));
        System.out.println(Calculadora.dividir(3.5, 6.5));
    }
}


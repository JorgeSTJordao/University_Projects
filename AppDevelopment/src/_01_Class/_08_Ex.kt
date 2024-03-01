package _01_Class

fun maiorSalario(funcinariosDados: List<Funcionario>): Float{
    var maior_salario = funcinariosDados[0].salario

    for (funcionario in funcinariosDados){
        if (funcionario.salario > maior_salario)
            maior_salario = funcionario.salario
    }
    return maior_salario
}

class Funcionario(val nome: String, val idade: Int, val salario: Float)

fun main() {
    val funcionario1: Funcionario = Funcionario("Pedro", 18, 4000f)
    val funcionario2: Funcionario = Funcionario("Edmundo", 16, 2500f)
    val funcionario3: Funcionario = Funcionario("Susana", 17, 6000f)

    val funcionariosDados: List<Funcionario> = mutableListOf(
        funcionario1,
        funcionario2,
        funcionario3
        )

    print(maiorSalario(funcionariosDados))
}
package a01_Class

//Funções lambda
var soma = {v1: Int, v2: Int -> v1 + v2}

var sub = {v1: Int, v2: Int -> v1 - v2}

var mul = {v1: Int, v2: Int -> v1 * v2}

var divs = {v1: Int, v2: Int -> v1 / v2}

//Função de ordem superior
fun ordemSuperior(num1: Int, num2: Int,
    soma: (Int, Int) -> Int,
    sub: (Int, Int) -> Int,
    mul: (Int, Int) -> Int,
    divs: (Int, Int) -> Int
)
{
    println("Soma: ${soma(num1, num2)}")
    println("Subtração: ${sub(num1, num2)}")
    println("Multiplicação: ${mul(num1, num2)}")
    println("Divisão: ${divs(num1, num2)}")

}
fun main() {
    print("Digite o primeiro número: ")
    val num1 = readLine()?.toIntOrNull()
    print("Digite o segundo número: ")
    val num2 = readLine()?.toIntOrNull()


    num1?.let {
        num2?.let {
            ordemSuperior(num1, num2, soma, sub, mul, divs)
        }
    }
}
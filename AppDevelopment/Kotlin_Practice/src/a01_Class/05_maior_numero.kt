package a01_Class

fun highestNumberFun(num1: Int, num2: Int): Int{
    if (num1 > num2)
        return num1
    return num2
}

fun main() {

    print("Digite o primeiro número: ")
    val num1: Int = readln().toInt()

    print("Digite o segundo número: ")
    val num2: Int = readln().toInt()

    println("O maior número é: ${highestNumberFun(num1, num2)}")

}
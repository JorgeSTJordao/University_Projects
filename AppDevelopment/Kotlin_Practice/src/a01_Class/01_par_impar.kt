package a01_Class

val par = {num: Int -> num % 2 == 0}

fun main() {
    print("Digite um número inteiro: ")
    val num = readLine()?.toIntOrNull()

    num?.let{
        if (par(num))
            println("Par")
        else
            println("Ímpar")
    }
}
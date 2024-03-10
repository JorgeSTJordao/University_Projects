package a01_Class

fun parOuImpar(num: Int): String{
    if (num % 2 == 0)
        return "Par"
    return "Ímpar "
}

fun main() {
    print("Digite um número inteiro: ")
    val num = readLine()?.toIntOrNull()

    num?.let{
        println(parOuImpar(num))
    }
}
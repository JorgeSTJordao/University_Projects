package a01_Class

fun parOuImpar(num: Int): Boolean{
    return num % 2 == 0
}

fun main() {
    val num: Int = 5

    println(parOuImpar(num))
}
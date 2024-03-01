package _01_Class

fun parOuImpar(num: Int): Boolean{
    if (num % 2 == 0)
        return true

    return false
}

fun main() {
    val num: Int = 5

    println(parOuImpar(num))
}
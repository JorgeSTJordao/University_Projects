package _01_Class

fun palindromo(palavra: String): String{

    //Bult-in function
    //return palavra.reversed()

    //Using "for"
    var palavra_inversa = ""

    for (i in (palavra.length) - 1 downTo 0){
        palavra_inversa = palavra_inversa.plus(palavra[i])
    }
    return palavra_inversa
}

fun main() {
    val palavra = "abbc"

    if (palavra in palindromo(palavra)) println(true) else println(false)
}
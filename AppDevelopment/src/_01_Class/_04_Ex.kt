package _01_Class

fun palindromo(palavra: String): String{

    //Função Bult-in
    //return palavra.reversed()

    //Usando somente "for"

    var palavraInversa = ""

    for (i in palavra.length - 1 downTo 0){
        palavraInversa = palavraInversa.plus(palavra[i])
    }

    return palavraInversa
}

fun main() {
    val palavra = "abbc"

    if (palavra == palindromo(palavra)) println(true) else println(false)
}
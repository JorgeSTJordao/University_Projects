package a01_Class

fun palindromo(palavra: String): Boolean{

    //Função Bult-in
    //return palavra.reversed() == palavra

    //Usando somente "for"
    var palavraInversa = ""

    for (i in palavra.length - 1 downTo 0){
        palavraInversa = palavraInversa.plus(palavra[i])
    }

    return palavraInversa == palavra
}

fun main() {
    val palavra = "abbc"

    println(palindromo(palavra))
}
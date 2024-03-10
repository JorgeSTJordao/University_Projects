package a01_Class

fun String.isPalindromo(): Boolean{
    var palavra = this.trim().lowercase()
    val espacosPalavra = palavra.split(" ")

    if (espacosPalavra.size > 1){
        var palavraJoined = ""
        for (palavraCore in espacosPalavra){
            palavraJoined += palavraCore
        }
        palavra = palavraJoined
    }

    return palavra.equals(palavra.reversed())
}

fun main() {
    print("Digite uma palavra qualquer: ")
    val palavra1 = readln()

    println(palavra1)
    println(palavra1.isPalindromo())
}
package _01_Class

fun maiorPalavra(vararg arrayPalavras: MutableList<String>): String{

    var maiorPalava = ""

    for (palavra in arrayPalavras){
        if (palavra.toString().length > maiorPalava.length)
            maiorPalava = palavra.toString()
    }

    return maiorPalava
}

fun main() {
    val arrayPalavras = mutableListOf("Banana", "Pera", "Abacaxi")

    println(maiorPalavra(arrayPalavras))
}
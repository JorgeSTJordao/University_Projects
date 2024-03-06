package a01_Class


fun maiorPalavra(arrayPalavras: List<String>): String{

    var maiorPalava = arrayPalavras[0]

    for (palavra in arrayPalavras){
        if (palavra.length > maiorPalava.length)
            maiorPalava = palavra
    }
    return maiorPalava
}

fun main() {
    val arrayPalavras = listOf("Bananax", "Pera", "Abacaxi")

    println(maiorPalavra(arrayPalavras))
}
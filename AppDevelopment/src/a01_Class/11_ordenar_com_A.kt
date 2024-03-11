package a01_Class

fun alfabetoComA(arrayPalavras: MutableList<String>): MutableList<String> {

    var arrayPalavrasA = mutableListOf<String>()

    for (palavra in arrayPalavras) {
        if (palavra.startsWith("A"))
            arrayPalavrasA.add(palavra)
    }

    return arrayPalavrasA
}

fun main() {
    val arrayPalavras = mutableListOf("Arara", "Arpa", "Abacaxi", "Besta", "Arco")

    print(alfabetoComA(arrayPalavras))
}
package a01_Class

fun alfabetoComA(arrayPalavras: List<String>): List<String> {

    var arrayPalavrasA: List<String> = listOf()

    for (palavra in arrayPalavras) {
        if (palavra.startsWith("A"))
            arrayPalavrasA = arrayPalavrasA.plus(palavra)
    }

    for (palavra in arrayPalavras){
        for (letra in palavra){

        }
    }
    return arrayPalavrasA
}

fun main() {
    val arrayPalavras = listOf("Arara", "Arpa", "Abacaxi", "Besta", "Arco")

    print(alfabetoComA(arrayPalavras))
}
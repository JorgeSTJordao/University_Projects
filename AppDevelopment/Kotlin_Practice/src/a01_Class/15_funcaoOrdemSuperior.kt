package a01_Class

var filtroPar = {valor: Int -> valor%2 == 0}

var dobraValor = {valor: Int -> valor*2}

var somarValor = {valor: Int, soma: Int -> soma + valor}

//pares
fun filtrarPares(numList: MutableList<Int>, filtroPar: (Int) -> Boolean): List<Int> {
    val valores = mutableListOf<Int>()
    for (num in numList) {
        if (filtroPar(num))
            valores.add(num)
    }
    return valores
}

//dobro
fun dobrarValores(numList: MutableList<Int>, dobraValor: (Int) -> Int): List<Int> {
    val valores = mutableListOf<Int>()
    for (num in numList)
        valores.add(dobraValor(num))
    return valores
}

//soma
fun somarValores(numList: MutableList<Int>, somaValor: (Int, Int) -> Int): Int{
    var soma = 0
    for (num in numList)
        soma = somarValor(num, soma)
    return soma
}
fun main() {
    val numList = mutableListOf(5, 4, 2, 3)
    println("Lista de pares: ${filtrarPares(numList, filtroPar)}")
    println("Lista de valores dobrados: ${dobrarValores(numList, dobraValor)}")
    println("Soma total: ${somarValores(numList, somarValor)}")
}
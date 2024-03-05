package a01_Class

fun main() {
    val dicionario = mapOf(Pair("Banana", "Banana"), Pair("Avião", "Plane"), Pair("Lago", "Lake"))

    for ((wPT, wEN) in dicionario)
        println("Original: $wPT | Tradução: $wEN" )
}
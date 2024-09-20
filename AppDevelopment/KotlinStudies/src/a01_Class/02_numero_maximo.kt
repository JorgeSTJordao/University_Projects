package a01_Class

import kotlin.random.Random

val maxNumber = {nums_array: MutableList<Int> -> nums_array.max()}

fun main() {
    val randomValues = MutableList(10) { Random.nextInt(0, 100)}
    println(randomValues)
    println(maxNumber(randomValues))
}
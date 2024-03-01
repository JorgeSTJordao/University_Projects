package _01_Class

import kotlin.math.max

fun maxNumber(nums_array: MutableList<Int>): Int{
    return nums_array.max()
}

fun main() {
    val nums_array: MutableList<Int> = mutableListOf(1, 2, 52, 23)

    println(maxNumber(nums_array))
}
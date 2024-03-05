package _01_Class

import kotlin.math.max

fun maxNumber(nums_array: IntArray): Int{
    return nums_array.max()
}

fun main() {
    val nums_array: IntArray = intArrayOf(1, 2, 52, 23)

    println(maxNumber(nums_array))
}
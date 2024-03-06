package a01_Class

fun sortList(numList: IntArray): IntArray{
    var aux: Int
    var indexMenor: Int = 0

    for (i in 0 .. numList.size - 2){
        var num_atual = numList[i]
        //O num_atual deve virar o menor da lista e trocar de lugar com o primeiro
        for (j in (i + 1) .. numList.size-1){
            if (numList[j] < num_atual){
                num_atual = numList[j]
                indexMenor = j
            }
        }
        if (num_atual != numList[i]){
            aux = numList[i]
            numList[i] = num_atual
            numList[indexMenor] = aux
        }
    }
    return numList
}

fun main() {
    var numsList = intArrayOf(3, 6, 2, 5, 4)

    //println(sortList(numsList)). It's not printing like this, I dunno what I messed up

    for (num in sortList(numsList))
        print("$num ")
}
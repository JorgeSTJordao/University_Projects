package _01_Class

import javafx.collections.transformation.SortedList

class Pessoa(val nome: String, val idade: Int){

}

fun main() {
    var arrayPessoas: MutableList<Pessoa> = mutableListOf(
        Pessoa("Peter", 23),
        Pessoa("Harry", 28),
        Pessoa("Mary Jane", 22)
    )

    var last = arrayPessoas.indexOf(Pessoa("Peter", 23))

    arrayPessoas = arrayPessoas.sortedBy{}
    print(arrayPessoas)
}
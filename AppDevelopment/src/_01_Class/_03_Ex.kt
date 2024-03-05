//Ref: https://www.programiz.com/kotlin-programming/examples/sort-custom-objects-property#:~:text=For%20sorting%20the%20list%20with,stored%20in%20the%20variable%20sortedList%20.

package _01_Class

class Pessoa(val nome: String, val idade: Int){
}

fun main() {
    //Lista de pessoas
    val arrayPessoas = ArrayList<Pessoa>()
    arrayPessoas.add(Pessoa("Peter Parker", 23))
    arrayPessoas.add(Pessoa("Harry Osborn", 28))
    arrayPessoas.add(Pessoa("Mary Jane", 22))

    //Lista ordenada
    val sortedList = arrayPessoas.sortedWith(compareBy{it.nome})

    for (pessoa in sortedList){
        println(pessoa.nome)
    }
}
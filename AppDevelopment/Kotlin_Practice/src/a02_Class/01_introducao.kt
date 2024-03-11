package a02_Class

//Classe aberta
open class Aula(var numeroAlunos: Int, var nomeDaDisciplina: String){
    val nomeDaDisciplinaCompleta: String
        get() = "Disiciplina: $nomeDaDisciplina"

    constructor(numeroAlunos: Int) : this(numeroAlunos, "legal"){
    }

    //Objeto estático que está associada à instância que se liga
    companion object{
        fun metodoStatic(){
            println("estático")
        }
    }
}

class AulaCompleta: Aula(25, "kotlin"){
}

interface MinhaInterface{
    val propriedade: Int

    fun abstrata()

    fun concreta(){
        println("Função concreta")
    }
}

class ImpInterface: MinhaInterface{
    override val propriedade: Int = 5

    override fun abstrata() {
        println("abstrata")
    }

    var firstName: String
    init {
        firstName = "Mark"
    }
    var lastName: String
    init {
        lastName = "Jorge"
    }
}

fun main() {
    val aula = Aula(42, "Mobile")
    println(aula.nomeDaDisciplinaCompleta)
    Aula.metodoStatic()

    var aulaCompleta = AulaCompleta()

    val constante = 4

    if (constante == 3){

    }else if(constante==4){

    }else{

    }

    var num = if(constante == 3) 3 else 5

    val listaDeCompras = listOf("Omo", "Downy", "Nescau", "Torrada", "Tubaina", "Toddy")

    //it: ponteiro para variável que está filtrando
    listaDeCompras
        .filter { it.startsWith("T")}
        .sortedBy { it }
        .map{it.uppercase()}
        .forEach{println(it)}

    when(num){
        3 -> print(3)
        5 -> print(5)
        else -> {

        }
    }
}
package a01_Class

class Triangulo(val altura: Float, val base: Float){
    fun area(): String{
        return "O valor da área é de ${(altura*base)/2} cm"
    }
}

fun main() {
    val triangulo1 = Triangulo(10f, 2.5f)
    println(triangulo1.area())
}
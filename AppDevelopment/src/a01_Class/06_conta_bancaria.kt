package a01_Class

class ContaBancaria(var saldo: Float, var limite: Float) {

    fun saque(valorPedido: Float) {

        if (valorPedido > (saldo + limite)) {
            throw Exception("Saldo insuficiente")
        }
        saldo -=valorPedido
        print(saldo)
    }
}
fun main() {
    val conta1: ContaBancaria = ContaBancaria(3000f, 1000f)
    conta1.saque(4001f)
}
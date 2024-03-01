package _01_Class

class ContaBancaria(var saldo: Float, var limite: Float) {

    fun saque(valorPedido: Float) {
        saldo -= valorPedido

        if (saldo < 0) {
            limite += saldo
            if (limite > 0)
                println("Ainda faltam R$ ${saldo * -1}. Você ainda pode emprestar R$ $limite de crédito")
            else
                println("Você excedeu o valor limite de empréstimo e não possui mais saldo")
        } else
            println("Saque de R$ $valorPedido foi retirado da sua conta. Saldo Atual: R$ $saldo")
    }
}
fun main() {
    val conta1: ContaBancaria = ContaBancaria(3000f, 1000f)
    conta1.saque(4000f)
}
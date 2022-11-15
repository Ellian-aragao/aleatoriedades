package aragao.ellian.github.conta.domain.models

import java.util.*

class Conta private constructor(
    val id: Long,
    val titular: String,
    val saldo: Double,
) {

    fun depositar(valor: Double): Conta {
        return Conta(id, titular, saldo + valor);
    }

    fun sacar(valor: Double): Conta {
        if (saldo < valor) {
            throw Exception("Saldo insuficiente");
        }
        return Conta( id, titular,saldo - valor);
    }

    data class Builder(
        var id: Long? = null,
        var titular: String? = null,
        var saldo: Double? = null,
    ) {
        fun id(id: Long) = apply { this.id = id }
        fun titular(titular: String) = apply { this.titular = titular }
        fun saldo(saldo: Double) = apply { this.saldo = saldo }
        fun build(): Conta {
            LinkedList<String>().apply {
                if (Objects.isNull(titular)) add("Titular não pode ser nulo")
                if (Objects.nonNull(saldo) && saldo!! < 0) add("Saldo deve ser maior que zero")
                if (isNotEmpty()) throw RuntimeException(joinToString(", "))
            }
            return Conta(id?: 0, titular!!, saldo ?: 0.0);
        }
    }
}

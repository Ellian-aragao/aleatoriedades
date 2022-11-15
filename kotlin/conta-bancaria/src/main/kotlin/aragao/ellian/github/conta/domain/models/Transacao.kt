package aragao.ellian.github.conta.domain.models

import java.util.*

class Transacao private constructor(
    val id: Long,
    val valor: Double,
    val descricao: String,
    val origem: Conta,
    val destino: Conta,
) {

    fun executarTransacao(): TransacaoResult {
        val origemSacada = origem.sacar(valor)
        val destinoDepositada = destino.depositar(valor)
        return TransacaoResult(origemSacada, destinoDepositada, this)
    }

    data class Builder(
        var id: Long? = null,
        var valor: Double? = null,
        var descricao: String? = null,
        var origem: Conta? = null,
        var destino: Conta? = null,
    ) {
        fun id(id: Long) = apply { this.id = id }
        fun valor(valor: Double) = apply { this.valor = valor }
        fun descricao(descricao: String) = apply { this.descricao = descricao }
        fun origem(origem: Conta) = apply { this.origem = origem }
        fun destino(destino: Conta) = apply { this.destino = destino }
        fun build(): Transacao {
            LinkedList<String>().apply {
                if (Objects.isNull(valor)) add("Valor não pode ser nulo")
                if (Objects.isNull(origem)) add("Origem não pode ser nula")
                if (Objects.isNull(destino)) add("Destino não pode ser nulo")
                if (Objects.nonNull(valor) && valor!! <= 0) add("Valor deve ser maior que zero")
                if (isNotEmpty()) throw RuntimeException(joinToString(", "))
            }

            return Transacao(id ?: 0, valor!!, descricao ?: "", origem!!, destino!!)
        }
    }
}

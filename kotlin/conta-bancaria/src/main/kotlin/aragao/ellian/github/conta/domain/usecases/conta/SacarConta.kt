package aragao.ellian.github.conta.domain.usecases.conta

import aragao.ellian.github.conta.domain.models.Conta

interface SacarConta {
    fun sacarConta(id:Long, valor: Double): Conta
}

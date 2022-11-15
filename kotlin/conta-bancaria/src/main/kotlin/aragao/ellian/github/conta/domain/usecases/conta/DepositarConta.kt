package aragao.ellian.github.conta.domain.usecases.conta

import aragao.ellian.github.conta.domain.models.Conta

interface DepositarConta {
    fun depositarContaComId(id: Long, valor: Double) : Conta
}

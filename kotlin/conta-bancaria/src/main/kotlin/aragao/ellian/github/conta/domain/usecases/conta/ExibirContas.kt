package aragao.ellian.github.conta.domain.usecases.conta

import aragao.ellian.github.conta.domain.models.Conta

interface ExibirContas {
    fun exibirContas(): List<Conta>
    fun buscaContaComId(id: Long): Conta
    fun buscaContaComTitular(titular: String): Conta
}

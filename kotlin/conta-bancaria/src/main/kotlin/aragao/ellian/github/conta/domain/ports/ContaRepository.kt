package aragao.ellian.github.conta.domain.ports

import aragao.ellian.github.conta.domain.models.Conta

interface ContaRepository {
    fun salvarConta(conta: Conta): Conta
    fun buscarContaPorTitular(titular: String): Conta
    fun buscarContaPorId(id: Long): Conta
    fun buscarTodasContas(): List<Conta>
    fun deletarConta(id: Long)
}

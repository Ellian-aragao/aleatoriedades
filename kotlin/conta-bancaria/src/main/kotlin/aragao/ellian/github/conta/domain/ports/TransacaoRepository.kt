package aragao.ellian.github.conta.domain.ports

import aragao.ellian.github.conta.domain.models.Transacao

interface TransacaoRepository {
    fun salvarTransacao(transacao: Transacao): Transacao
    fun buscarTransacoes(): List<Transacao>
    fun buscarTransacoesPorContaId(id: Long): List<Transacao>
    fun buscarTransacaoPorTitular(titular: String): List<Transacao>
}

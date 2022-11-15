package aragao.ellian.github.conta.domain.models

import java.time.LocalDateTime

data class TransacaoResult(val contaSacada: Conta, val contaDepositada: Conta, val transacao: Transacao) {
    val dataExecucao = LocalDateTime.now();

    operator fun component4(): LocalDateTime = dataExecucao
}

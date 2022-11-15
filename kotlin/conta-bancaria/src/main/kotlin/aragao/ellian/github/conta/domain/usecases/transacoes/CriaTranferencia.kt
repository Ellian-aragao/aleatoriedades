package aragao.ellian.github.conta.domain.usecases.transacoes

import aragao.ellian.github.conta.domain.models.Conta
import aragao.ellian.github.conta.domain.models.Transacao

interface CriaTranferencia {
    fun transferir(valor: Double, descricao: String, origem: Conta, destino: Conta): Transacao
}

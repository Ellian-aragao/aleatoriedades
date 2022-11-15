package aragao.ellian.github.conta.domain.usecases.conta

import aragao.ellian.github.conta.domain.models.Conta

interface CriarConta {
    fun criarConta(titular: String): Conta
}

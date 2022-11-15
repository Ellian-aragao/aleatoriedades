package aragao.ellian.github.conta.domain.usecases.conta.impl

import aragao.ellian.github.conta.domain.usecases.conta.CriarConta
import aragao.ellian.github.conta.domain.usecases.conta.DepositarConta
import aragao.ellian.github.conta.domain.usecases.conta.ExibirContas
import aragao.ellian.github.conta.domain.usecases.conta.SacarConta

interface ContaService: CriarConta, DepositarConta, SacarConta, ExibirContas {
}

package aragao.ellian.github.conta.domain.usecases.conta.impl

import aragao.ellian.github.conta.domain.models.Conta
import aragao.ellian.github.conta.domain.ports.ContaRepository
import aragao.ellian.github.conta.domain.usecases.conta.CriarConta
import aragao.ellian.github.conta.domain.usecases.conta.DepositarConta
import aragao.ellian.github.conta.domain.usecases.conta.ExibirContas
import aragao.ellian.github.conta.domain.usecases.conta.SacarConta

class ContaUseCases(private val repository: ContaRepository): ContaService {

    override fun criarConta(titular: String): Conta {
        val conta = Conta.Builder()
            .titular(titular)
            .build()
        return repository.salvarConta(conta)
    }

    override fun depositarContaComId(id: Long, valor: Double): Conta {
        val conta = repository.buscarContaPorId(id)
        val contaDepositada = conta.depositar(valor)
        return repository.salvarConta(contaDepositada)
    }

    override fun sacarConta(id: Long, valor: Double): Conta {
        val conta = repository.buscarContaPorId(id)
        val contaSacada = conta.sacar(valor)
        return repository.salvarConta(contaSacada)
    }

    override fun exibirContas(): List<Conta> {
        return repository.buscarTodasContas()
    }
}

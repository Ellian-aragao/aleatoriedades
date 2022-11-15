package aragao.ellian.github.conta.infra.adapter

import aragao.ellian.github.conta.domain.models.Conta
import aragao.ellian.github.conta.domain.ports.ContaRepository

class ContaRepositoryInMemoryImpl : ContaRepository {

    private val conta = Conta.Builder()
        .titular("Ellian")
        .build()

    private val contas = mutableListOf(conta)

    override fun salvarConta(conta: Conta): Conta {
        val contaWithId = conta.with()
            .id(contas.size.toLong())
            .build()
        contas.add(contaWithId)
        return contaWithId
    }

    override fun buscarContaPorTitular(titular: String): Conta {
        try {
            return contas.first { it.titular == titular }
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("Conta não encontrada para o titular: '$titular'")
        }
    }

    override fun buscarContaPorId(id: Long): Conta {
        try {
            return contas.first { it.id == id }
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("Conta não encontrada com id: '$id'")
        }
    }

    override fun buscarTodasContas(): List<Conta> {
        return contas
    }

    override fun deletarConta(id: Long) {
        val nothingRemoved = !contas.removeIf { it.id == id }
        if (nothingRemoved) throw NoSuchElementException("Conta não encontrada para deletar")
    }
}

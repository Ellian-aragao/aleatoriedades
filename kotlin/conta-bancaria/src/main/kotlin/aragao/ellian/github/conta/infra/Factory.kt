package aragao.ellian.github.conta.infra

import aragao.ellian.github.conta.domain.ports.ContaRepository
import aragao.ellian.github.conta.domain.usecases.conta.impl.ContaService
import aragao.ellian.github.conta.domain.usecases.conta.impl.ContaServiceImpl
import aragao.ellian.github.conta.infra.adapter.ContaRepositoryInMemoryImpl

class Factory {
    companion object {
        private val contaRepository: ContaRepository = ContaRepositoryInMemoryImpl()
        val contaService: ContaService = ContaServiceImpl(contaRepository)

    }
}

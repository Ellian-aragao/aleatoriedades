package aragao.ellian.github.conta.domain.usecases.conta.impl

import aragao.ellian.github.conta.domain.models.Conta
import aragao.ellian.github.conta.domain.ports.ContaRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class ContaUseCasesTest {

    @MockK
    lateinit var conta: Conta

    @MockK
    lateinit var repository: ContaRepository

    @InjectMockKs
    lateinit var contaUsecases: ContaUseCases

    @Test
    fun `deve criar uma conta`() {
        every { conta.titular } returns "User"
        every { repository.salvarConta(any()) } returns conta
        val contaResponse = contaUsecases.criarConta("User")
        assertEquals("User", contaResponse.titular)
        verify { repository.salvarConta(any()) }
    }

    @Test
    fun `deve depositar na conta`() {
        every { repository.buscarContaPorId(any()) } returns conta
        every { conta.depositar(any()) } returns conta
        every { repository.salvarConta(any()) } returns conta
        val contaResponse = contaUsecases.depositarContaComId(1, 100.0)
        assertEquals(conta, contaResponse)
        verify { repository.buscarContaPorId(any()) }
        verify { conta.depositar(any()) }
        verify { repository.salvarConta(any()) }
    }

    @Test
    fun `deve sacar da conta`() {
        every { repository.buscarContaPorId(any()) } returns conta
        every { conta.sacar(any()) } returns conta
        every { repository.salvarConta(any()) } returns conta
        val contaResponse = contaUsecases.sacarConta(1, 100.0)
        assertEquals(conta, contaResponse)
        verify { repository.buscarContaPorId(any()) }
        verify { conta.sacar(any()) }
        verify { repository.salvarConta(any()) }
    }
}

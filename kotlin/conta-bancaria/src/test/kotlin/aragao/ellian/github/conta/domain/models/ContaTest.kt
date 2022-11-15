package aragao.ellian.github.conta.domain.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ContaTest {

    @Test
    fun `deve tentar criar uma conta com titular nulo`() {
        val ex = assertThrows(RuntimeException::class.java) {
            Conta.Builder()
                .build()
        }
        assertEquals("Titular não pode ser nulo", ex.message!!)
    }

    @Test
    fun `deve tentar criar uma conta com saldo negativo`() {
        val ex = assertThrows(RuntimeException::class.java) {
            Conta.Builder()
                .titular("Teste User")
                .saldo(-100.0)
                .build()
        }
        assertEquals("Saldo deve ser maior que zero", ex.message!!)
    }

    @Test
    fun `deve tentar criar uma conta sem nome e com saldo negativo`() {
        val ex = assertThrows(RuntimeException::class.java) {
            Conta.Builder()
                .saldo(-100.0)
                .build()
        }
        assertEquals("Titular não pode ser nulo, Saldo deve ser maior que zero", ex.message!!)
    }

    @Test
    fun `deve criar uma conta`() {
        val titular = "Teste User"
        val conta: Conta = Conta.Builder()
            .titular(titular)
            .build()

        assertEquals(titular, conta.titular)
        assertEquals(0.0, conta.saldo)
        assertEquals(0, conta.id)
    }

    @Test
    fun `deve testar deposito`() {
        val titular = "Teste User"
        val conta: Conta = Conta.Builder()
            .titular(titular)
            .build()

        assertEquals(titular, conta.titular)
        assertEquals(0.0, conta.saldo)
        assertEquals(0, conta.id)

        val valorDeposito = 100.0
        val contaDepositada = conta.depositar(valorDeposito)

        assertEquals(titular, conta.titular)
        assertEquals(0.0, conta.saldo)
        assertEquals(0, conta.id)

        assertEquals(titular, contaDepositada.titular)
        assertEquals(valorDeposito, contaDepositada.saldo)
        assertEquals(0, contaDepositada.id)
    }

    @Test
    fun `deve tentar sacar mais do que possui de saldo`() {
        val titular = "Teste User"
        val conta: Conta = Conta.Builder()
            .titular(titular)
            .saldo(100.0)
            .build()

        assertEquals(titular, conta.titular)
        assertEquals(100.0, conta.saldo)
        assertEquals(0, conta.id)

        val ex = assertThrows(Exception::class.java) {
            conta.sacar(1000.0)
        }
        assertEquals("Saldo insuficiente", ex.message!!)

        assertEquals(titular, conta.titular)
        assertEquals(100.0, conta.saldo)
        assertEquals(0, conta.id)

    }

    @Test
    fun `deve testar saque`() {
        val titular = "Teste User"
        val conta: Conta = Conta.Builder()
            .titular(titular)
            .saldo(100.0)
            .build()

        assertEquals(titular, conta.titular)
        assertEquals(100.0, conta.saldo)
        assertEquals(0, conta.id)

        val contaSacada = conta.sacar(100.0)

        assertEquals(titular, conta.titular)
        assertEquals(100.0, conta.saldo)
        assertEquals(0, conta.id)

        assertEquals(titular, contaSacada.titular)
        assertEquals(0.0, contaSacada.saldo)
        assertEquals(0, contaSacada.id)
    }
}

package aragao.ellian.github.conta.domain.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit

internal class TransacaoTest {

    private val conta1 = Conta.Builder()
        .titular("Teste User1")
        .saldo(100.0)
        .build()

    private val conta2 = Conta.Builder()
        .titular("Teste User2")
        .saldo(200.0)
        .build()

    @Test
    fun `deve executar uma transacao e ter valores alterados`() {
        val transacao = Transacao.Builder()
            .valor(100.0)
            .origem(conta1)
            .destino(conta2)
            .build()

        val stateFunctionVerifier = {
            assertEquals(conta1, transacao.origem)
            assertEquals("Teste User1", transacao.origem.titular)
            assertEquals(100.0, transacao.origem.saldo)
            assertEquals(0, transacao.origem.id)

            assertEquals(conta2, transacao.destino)
            assertEquals("Teste User2", transacao.destino.titular)
            assertEquals(200.0, transacao.destino.saldo)
            assertEquals(0, transacao.destino.id)
        }


        stateFunctionVerifier()
        val (origemSacada, destinoSacada, transacaoCopy, dataExecucao) = transacao.executarTransacao()
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), dataExecucao.truncatedTo(ChronoUnit.SECONDS))
        assertEquals(transacao,transacaoCopy)
        stateFunctionVerifier()

        assertNotEquals(conta1, origemSacada)
        assertEquals("Teste User1", origemSacada.titular)
        assertEquals(0.0, origemSacada.saldo)
        assertEquals(0, origemSacada.id)

        assertNotEquals(conta2, destinoSacada)
        assertEquals("Teste User2", destinoSacada.titular)
        assertEquals(300.0, destinoSacada.saldo)
        assertEquals(0, destinoSacada.id)
    }
}

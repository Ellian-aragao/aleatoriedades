package aragao.ellian.github.conta.infra.entrypoint

import aragao.ellian.github.conta.domain.models.Conta
import aragao.ellian.github.conta.infra.Factory
import kotlin.system.exitProcess

class CliInterface {
    private val regexNomeTitular = Regex("^[a-zA-Z ]*\$")

    private fun exibirMenuPrincipal() {
        println("-----main menu-----")
        println("1 - Criar conta")
        println("2 - exibir contas")
        println("3 - acessar conta")
        println("4 - Sair")
        print("main menu input: ")
    }

    private fun exibirMenuBuscarConta() {
        println("-----buscar conta menu-----")
        println("1 - Buscar por id")
        println("2 - Buscar por titular")
        println("3 - Voltar")
        print("buscar conta menu input: ")
    }

    private fun exibirMenuConta() {
        println("-----conta menu-----")
        println("1 - Depositar")
        println("2 - Sacar")
        println("3 - Voltar")
        print("conta menu input: ")
    }

    private fun lerOpcaoDoMenuNumerico(): Int {
        return try {
            readLine()!!.toInt()
        } catch (e: Exception) {
            println("Opção inválida, digite números conforme menu")
            -1
        }
    }

    fun exibirSolicitacaoDoNomeDoTitular() = println("Digite o nome do titular")

    private fun lerNomeDoTitular(): String {
        val line = readLine()
        try {
            if (line!!.matches(regexNomeTitular)) {
                return line
            }
            println("Nome inválido: não segue convensão de letras")
            throw RuntimeException("Nome inválido: não segue convensão de letras")
        } catch (e: Exception) {
            println("Nome inválido")
            throw RuntimeException("Nome inválido", e)
        }
    }

    fun mainLoopIteraction() {
        while (true) {
            exibirMenuPrincipal()
            val opcao = lerOpcaoDoMenuNumerico()
            when (opcao) {
                1 -> criarContaLoop()
                2 -> exibirContas()
                3 -> acessarContaLoop()
                4 -> exitProcess(0)
                else -> println("Opção inválida")
            }
        }
    }

    private fun acessarContaLoop() {
        var loop = true
        while (loop) {
            exibirMenuBuscarConta()
            val opcao = lerOpcaoDoMenuNumerico()
            val conta = when (opcao) {
                1 -> acessarContaPorIdLoop()
                2 -> acessarContaPorTitularLoop()
                3 -> {
                    loop = false
                    null
                }

                else -> {
                    println("Opção inválida")
                    null
                }
            }
            conta?.let(this::menuContaLoop)
        }
    }

    private fun menuContaLoop(contaInitial: Conta) {
        var conta = contaInitial
        var loop = true
        while (loop) {
            println("Conta: ${conta.id} - ${conta.titular} - Saldo: ${conta.saldo}")
            exibirMenuConta()
            val opcao = lerOpcaoDoMenuNumerico()
            conta = when (opcao) {
                1 -> depositarContaLoop(conta)
                2 -> sacarContaLoop(conta)
                3 -> {
                    loop = false
                    continue
                }

                else -> {
                    println("Opção inválida")
                    continue
                }
            }
        }
    }

    private fun sacarContaLoop(conta: Conta): Conta {
        return try {
            println("Digite o valor a ser sacado")
            val valor = lerValorDouble()
            Factory.contaService.sacarConta(conta.id, valor)

        } catch (e: Exception) {
            println("Erro ao sacar: ${e.message}")
            conta
        }
    }

    private fun lerValorDouble(): Double {
        try {
            return readLine()!!.toDouble()
        } catch (e: Exception) {
            println("Valor inválido")
            throw RuntimeException("Valor inválido", e)
        }
    }

    private fun depositarContaLoop(conta: Conta): Conta {
        return try {
            println("Digite o valor a ser depositado")
            val valor = lerValorDouble()
            Factory.contaService.depositarContaComId(conta.id, valor)
        } catch (e: Exception) {
            println("Erro ao depositar: ${e.message}")
            conta
        }
    }

    private fun acessarContaPorTitularLoop(): Conta? {
        return try {
            exibirSolicitacaoDoNomeDoTitular()
            val titular = lerNomeDoTitular()
            Factory.contaService.buscaContaComTitular(titular)
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    fun acessarContaPorIdLoop(): Conta? {
        return try {
            println("Digite o id da conta")
            val id = lerOpcaoDoMenuNumerico()
            Factory.contaService.buscaContaComId(id.toLong())
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    private fun exibirContas() = Factory.contaService.exibirContas().forEach { println(it) }

    private fun criarContaLoop() {
        while (true) {
            try {
                exibirSolicitacaoDoNomeDoTitular()
                val nome = lerNomeDoTitular()
                val conta = Factory.contaService.criarConta(nome)
                println("Conta criada com sucesso: $conta")
                return
            } catch (e: Exception) {
                println("Erro ao criar conta: ${e.message}")
            }
        }
    }
}

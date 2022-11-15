package aragao.ellian.github.conta.infra.adapter.entrypoint

class CliInterface {
    private val regex = Regex("^[a-zA-Z ]*\$")

    fun exibirMenu() {
        println("1 - Criar conta")
        println("2 - exibir contas")
        println("3 - acessar conta")
        println("6 - Sair")
    }

    fun lerOpcaoDoMenu(): Int {
        try {
            return readLine()!!.toInt()
        } catch (e: Exception) {
            println("Opção inválida")
            throw RuntimeException("Opção inválida", e)
        }
    }

    fun exibirSolicitacaoDoNomeDoTitular() = println("Digite o nome do titular")

    fun lerNomeDoTitular(): String {
        val line = readLine()
        try {
            if (line!!.matches(regex)) {
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
            exibirMenu()

        }
    }
}

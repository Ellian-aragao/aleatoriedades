package aragao.ellian.github.conta

import aragao.ellian.github.conta.infra.entrypoint.CliInterface

fun main() {
    val cliInterface = CliInterface()
    cliInterface.mainLoopIteraction()
}

package aragao.ellian.github.tamagotchi

import aragao.ellian.github.tamagotchi.constants.BoundedLimits
import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi.DeadReasons
import aragao.ellian.github.tamagotchi.models.Tamagotchi

fun main() {
    println("Give a name to your Tamagotchi:")
    val tamagotchi = Tamagotchi(readLine()!!)
    while (tamagotchi.isAlive()) {
        println(tamagotchi)
        println("What do you want to do with your Tamagotchi?")
        println("eat - to feed your Tamagotchi")
        println("play - to play with your Tamagotchi")
        println("shower - to take a shower with your Tamagotchi")
        println("sleep - to let your Tamagotchi sleep")
        with(actionStringToActionMapper(readLine()!!)) { this.action?.let { tamagotchi.doAction(it) } }
        println(tamagotchi)
        tamagotchi.randomicActionEffect(BoundedLimits.Tamagotchi.Actions.values().random())
        println(tamagotchi)
        tamagotchi.nextAge()
    }
    tamagotchi.deadReason().let(::deadReasonToPrintMessage)
}

private fun deadReasonToPrintMessage(it: DeadReasons) {
    when (it) {
        DeadReasons.OLD_AGE -> println("Your Tamagotchi is dead because it is too old.")
        DeadReasons.STARVED -> println("Your Tamagotchi is dead because it is too hungry.")
        DeadReasons.BOREDOM -> println("Your Tamagotchi is dead because it is too bored.")
        DeadReasons.SICK -> println("Your Tamagotchi is dead because it is too sick.")
        DeadReasons.AUTOIMMUNE -> println("Your Tamagotchi is dead because it is immune.")
        DeadReasons.HAPPINESS -> println("Your Tamagotchi is dead because it is too happy.")
        DeadReasons.FULL_OF_EATING -> println("Your Tamagotchi is dead because it is full of eating.")
    }
}

fun actionStringToActionMapper(readedLine: String): BoundedLimits.ActionsMapping {
    return when (readedLine) {
        "eat" -> BoundedLimits.ActionsMapping.EAT
        "play" -> BoundedLimits.ActionsMapping.PLAY
        "shower" -> BoundedLimits.ActionsMapping.SHOWER
        "sleep" -> BoundedLimits.ActionsMapping.NONE
        else -> BoundedLimits.ActionsMapping.UNKNOWN
    }
}


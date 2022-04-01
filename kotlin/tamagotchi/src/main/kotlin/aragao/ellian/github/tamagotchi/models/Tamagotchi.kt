package aragao.ellian.github.tamagotchi.models

import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi
import aragao.ellian.github.tamagotchi.exceptions.AgeOutOfBoundTamagotchiException

class Tamagotchi(val name: String) {
    var age = 0
        private set
    var hunger = 10
        private set
    var happiness = 10
        private set
    var health = 10
        private set

    fun plusAge(): Int {
        if (age >= Tamagotchi.MAX_AGE) {
            throw AgeOutOfBoundTamagotchiException();
        }
        return ++age;
    }

    fun isAlive(): Boolean {
        return age < Tamagotchi.MAX_AGE && listOf(hunger, happiness, health)
            .map(this::doNotPassLimits)
            .reduce(Boolean::and)
    }

    private fun doNotPassLimits(value: Int): Boolean {
        return !(value <= Tamagotchi.DOWN_LIMIT || value >= Tamagotchi.UP_LIMIT)
    }

    override fun toString(): String {
        return "Tamagotchi(name='$name', age=$age, hunger=$hunger, happiness=$happiness, health=$health)"
    }

    fun eat() {
        TODO("Not yet implemented")
    }
}

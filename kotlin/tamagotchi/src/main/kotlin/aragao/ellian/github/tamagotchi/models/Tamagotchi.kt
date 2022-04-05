package aragao.ellian.github.tamagotchi.models

import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi
import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi.Actions.*
import aragao.ellian.github.tamagotchi.exceptions.AgeOutOfBoundTamagotchiException
import aragao.ellian.github.tamagotchi.exceptions.HealthOutOfBoundTamagotchiException
import aragao.ellian.github.tamagotchi.exceptions.HungerOutOfBoundTamagotchiException

class Tamagotchi(val name: String) {
    var age = Tamagotchi.Default.AGE
        private set(value) {
            if (age >= Tamagotchi.MAX_AGE) {
                throw AgeOutOfBoundTamagotchiException(age)
            }
            field = value
        }

    var hunger = Tamagotchi.Default.HUNGER
        private set(value) {
            if (isOutOfLimits(hunger)) {
                throw HungerOutOfBoundTamagotchiException(hunger)
            }
            field = value
        }

    var happiness = Tamagotchi.Default.HAPPINESS
        private set(value) {
            if (isOutOfLimits(happiness)) {
                throw HealthOutOfBoundTamagotchiException(happiness)
            }
            field = value
        }

    var health = Tamagotchi.Default.HEALTH
        private set(value) {
            if (isOutOfLimits(health)) {
                throw HealthOutOfBoundTamagotchiException(health)
            }
            field = value
        }

    fun nextAge(): Int = ++age

    fun isAlive(): Boolean = age < Tamagotchi.MAX_AGE && listOf(hunger, happiness, health)
        .map(this::isInLimits)
        .reduce(Boolean::and)

    fun doAction(action: Tamagotchi.Actions): Int {
        return when (action) {
            EAT -> eat()
            SHOWER -> takeShower()
            PLAY -> play()
            UNKNOWN -> unkownAction()
        }
    }

    fun unkownAction(): Int {
        happiness += Tamagotchi.UnkownAction.HAPPINESS
        return happiness
    }

    fun eat(): Int {
        hunger += Tamagotchi.Eat.HUNGER
        health += Tamagotchi.Eat.HEALTH
        return hunger
    }

    fun takeShower(): Int {
        health += Tamagotchi.Shower.HEALTH
        happiness += Tamagotchi.Shower.HAPPINESS
        return health
    }

    fun play(): Int {
        happiness += Tamagotchi.Play.HAPPINESS
        hunger += Tamagotchi.Play.HUNGER
        health += Tamagotchi.Play.HEALTH
        return happiness
    }

    fun randomicActionEffect(action: Tamagotchi.Actions): Int {
        val randomValueIncrementer = (-5..5).random()
        when (action.ordinal % 3) {
            0 -> health += randomValueIncrementer
            1 -> happiness += randomValueIncrementer
            2 -> hunger += randomValueIncrementer
        }
        return randomValueIncrementer
    }

    fun deadReason(): Tamagotchi.DeadReasons {
        return when {
            age > Tamagotchi.MAX_AGE -> Tamagotchi.DeadReasons.OLD_AGE
            isOutOfLimits(hunger) -> if (hunger > Tamagotchi.UP_LIMIT) Tamagotchi.DeadReasons.STARVED else Tamagotchi.DeadReasons.FULL_OF_EATING
            isOutOfLimits(happiness) -> if (happiness > Tamagotchi.UP_LIMIT) Tamagotchi.DeadReasons.HAPPINESS else Tamagotchi.DeadReasons.BOREDOM
            isOutOfLimits(health) -> if (health > Tamagotchi.UP_LIMIT) Tamagotchi.DeadReasons.SICK else Tamagotchi.DeadReasons.AUTOIMMUNE
            else -> throw IllegalStateException("Tamagotchi is alive")
        }
    }

    private fun isInLimits(value: Int): Boolean = value in Tamagotchi.DOWN_LIMIT..Tamagotchi.UP_LIMIT

    private fun isOutOfLimits(value: Int): Boolean = value !in Tamagotchi.DOWN_LIMIT..Tamagotchi.UP_LIMIT

    override fun toString(): String {
        return "Tamagotchi(name='$name', age=$age, hunger=$hunger, happiness=$happiness, health=$health)"
    }
}

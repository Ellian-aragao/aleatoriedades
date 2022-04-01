package aragao.ellian.github.tamagotchi.constants

object BoundedLimits {
    object Tamagotchi {
        const val UP_LIMIT = 15;
        const val DOWN_LIMIT = 0;
        const val MAX_AGE = 100;

        object Default {
            const val AGE = 0
            const val HUNGER = 10
            const val HAPPINESS = 10
            const val HEALTH = 10
        }

        object Eat {
            const val HUNGER = -2
            const val HEALTH = -2
        }

        object Shower {
            const val HEALTH = 7
            const val HAPPINESS = 3
        }

        object Play {
            const val HAPPINESS = 7
            const val HEALTH = -2
            const val HUNGER = -2
        }
    }
}

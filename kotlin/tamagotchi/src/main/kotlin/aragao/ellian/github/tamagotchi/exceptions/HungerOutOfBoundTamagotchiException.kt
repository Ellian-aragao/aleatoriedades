package aragao.ellian.github.tamagotchi.exceptions

class HungerOutOfBoundTamagotchiException(hunger: Int) : OutOfBoundLimitsTamagotchiException() {
    override val message = "Hunger out of bound: $hunger"
}

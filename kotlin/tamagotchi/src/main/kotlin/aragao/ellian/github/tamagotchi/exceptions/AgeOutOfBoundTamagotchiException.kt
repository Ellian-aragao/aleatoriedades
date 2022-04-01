package aragao.ellian.github.tamagotchi.exceptions

class AgeOutOfBoundTamagotchiException : OutOfBoundLimitsTamagotchiException() {
    override val message = "Age must be between 0 and 100"
}

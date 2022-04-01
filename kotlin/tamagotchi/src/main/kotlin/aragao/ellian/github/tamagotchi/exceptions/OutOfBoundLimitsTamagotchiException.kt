package aragao.ellian.github.tamagotchi.exceptions

open class OutOfBoundLimitsTamagotchiException(attribute: String, value: Int) : RuntimeException() {
    override val message = "$attribute out of bound: $value"
}

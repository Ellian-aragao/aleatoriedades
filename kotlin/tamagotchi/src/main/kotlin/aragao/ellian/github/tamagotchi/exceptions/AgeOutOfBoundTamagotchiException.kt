package aragao.ellian.github.tamagotchi.exceptions

class AgeOutOfBoundTamagotchiException(age: Int) : OutOfBoundLimitsTamagotchiException("Age", age)

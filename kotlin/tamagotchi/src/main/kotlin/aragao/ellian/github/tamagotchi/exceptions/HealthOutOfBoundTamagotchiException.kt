package aragao.ellian.github.tamagotchi.exceptions

class HealthOutOfBoundTamagotchiException(health: Int) : OutOfBoundLimitsTamagotchiException("Health", health)

package aragao.ellian.github.tamagotchi.constants

import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoundedLimitsTest {
    @Test
    fun `should assert default values from tamagotchi`() {
        assertEquals(15 ,Tamagotchi.UP_LIMIT)
        assertEquals(0 ,Tamagotchi.DOWN_LIMIT)
        assertEquals(100 ,Tamagotchi.MAX_AGE)
    }
}

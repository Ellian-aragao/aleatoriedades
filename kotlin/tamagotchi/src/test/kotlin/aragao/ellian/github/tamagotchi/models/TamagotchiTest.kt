package aragao.ellian.github.tamagotchi.models

import aragao.ellian.github.tamagotchi.constants.BoundedLimits
import aragao.ellian.github.tamagotchi.exceptions.AgeOutOfBoundTamagotchiException
import aragao.ellian.github.tamagotchi.exceptions.HungerOutOfBoundTamagotchiException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class TamagotchiTest {
    @Test
    fun `should be able to create a tamagotchi`() {
        val tamagotchi = Tamagotchi("tamagotchi")
        assertNotNull(tamagotchi)
    }

    @Test
    fun `should verify if tamagotchi init with default values`() {
        val tamagotchi = Tamagotchi("tamagotchi")
        assertEquals("tamagotchi", tamagotchi.name)
        assertEquals(10, tamagotchi.hunger)
        assertEquals(10, tamagotchi.happiness)
        assertEquals(10, tamagotchi.health)
        assertEquals(0, tamagotchi.age)
    }

    @Test
    fun `should verify tamagotchi is alive in starter mode`() {
        val tamagotchi = Tamagotchi("tamagotchi")
        assertTrue(tamagotchi.isAlive())
    }

    @Test
    fun `should verify tamagotchi is not alive when called plus age max times`() {
        val tamagotchi = Tamagotchi("tamagotchi")
        repeat(BoundedLimits.Tamagotchi.MAX_AGE) { tamagotchi.plusAge() }
        assertFalse(tamagotchi.isAlive())
    }

    @Test
    fun `should throw AgeOutOfBoundTamagotchiException when called plus age more then constant`() {
        val tamagotchi = Tamagotchi("tamagotchi")
        assertThrows<AgeOutOfBoundTamagotchiException> {
            repeat(BoundedLimits.Tamagotchi.MAX_AGE + 1) { tamagotchi.plusAge() }
        }
    }

    @Test
    fun `should throw HungerOutOfBoundTamagotchiException when tamagotchi hunger is more then constant`() {
        val tamagotchi = Tamagotchi("tamagotchi")
        tamagotchi.eat()
        assertThrows<HungerOutOfBoundTamagotchiException> { tamagotchi.hunger }
    }

}

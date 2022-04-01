package aragao.ellian.github.tamagotchi.models

import aragao.ellian.github.tamagotchi.constants.BoundedLimits
import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi.Default
import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi.Play
import aragao.ellian.github.tamagotchi.constants.BoundedLimits.Tamagotchi.Shower
import aragao.ellian.github.tamagotchi.exceptions.AgeOutOfBoundTamagotchiException
import aragao.ellian.github.tamagotchi.exceptions.HealthOutOfBoundTamagotchiException
import aragao.ellian.github.tamagotchi.exceptions.HungerOutOfBoundTamagotchiException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

private const val tamagotchiName = "tamagotchi"

internal class TamagotchiTest {

    @Nested
    inner class GenericTamagotchiTest {

        @Test
        fun `should be able to create a tamagotchi`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertNotNull(tamagotchi)
        }

        @Test
        fun `should verify if tamagotchi init with default values`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertEquals(tamagotchiName, tamagotchi.name)
            assertEquals(Default.AGE, tamagotchi.age)
            assertEquals(Default.HUNGER, tamagotchi.hunger)
            assertEquals(Default.HAPPINESS, tamagotchi.happiness)
            assertEquals(Default.HEALTH, tamagotchi.health)
        }

        @Test
        fun `should verify tamagotchi is alive in starter mode`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertTrue(tamagotchi.isAlive())
        }

        @Test
        fun `should generate toString with attributes from class`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertEquals("Tamagotchi(name='$tamagotchiName', age=${Default.AGE}, hunger=${Default.HUNGER}, happiness=${Default.HAPPINESS}, health=${Default.HEALTH})",
                tamagotchi.toString())
        }

        @Test
        fun `should verify random action from tamagotchi`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            val attributesBefore = listOf(tamagotchi.health, tamagotchi.happiness, tamagotchi.hunger)
            tamagotchi.randomicAction()
            val attributesAfter = listOf(tamagotchi.health, tamagotchi.happiness, tamagotchi.hunger)
            assertNotEquals(attributesBefore, attributesAfter)
        }
    }

    @Nested
    inner class TamagotchiAgeTest {
        @Test
        fun `should verify tamagotchi is not alive when called plus age max times`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            repeat(BoundedLimits.Tamagotchi.MAX_AGE) { tamagotchi.plusAge() }
            assertFalse(tamagotchi.isAlive())
        }

        @Test
        fun `should throw AgeOutOfBoundTamagotchiException when called plus age more then constant`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertThrows<AgeOutOfBoundTamagotchiException> {
                repeat(BoundedLimits.Tamagotchi.MAX_AGE + 1) { tamagotchi.plusAge() }
            }
        }
    }

    @Nested
    inner class TamagotchiHungerTest {
        @Test
        fun `should throw HungerOutOfBoundTamagotchiException when tamagotchi hunger is more then constant`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertThrows<HungerOutOfBoundTamagotchiException> {
                repeat(BoundedLimits.Tamagotchi.UP_LIMIT + 1) { tamagotchi.eat() }
            }
        }

        @Test
        fun `should verify hunger and health are decremented when called eat`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            val hunger = tamagotchi.hunger
            val health = tamagotchi.health
            tamagotchi.eat()
            assertEquals(hunger - 2, tamagotchi.hunger)
            assertEquals(health - 2, tamagotchi.health)
        }
    }

    @Nested
    inner class TamagotchiHealthTest {
        @Test
        fun `should throw HealthOutOfBoundTamagotchiException when tamagotchi health is more then constant`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertThrows<HealthOutOfBoundTamagotchiException> {
                repeat(BoundedLimits.Tamagotchi.UP_LIMIT + 1) { tamagotchi.takeShower() }
            }
        }

        @Test
        fun `should verify health and happiness are decremented when called takeShower`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            val health = tamagotchi.health
            val happiness = tamagotchi.happiness
            tamagotchi.takeShower()
            assertEquals(health + Shower.HEALTH, tamagotchi.health)
            assertEquals(happiness + Shower.HAPPINESS, tamagotchi.happiness)
        }
    }

    @Nested
    inner class TamagotchiPlayTest {
        @Test
        fun `should throw HealthOutOfBoundTamagotchiException when tamagotchi health is more then constant`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            assertThrows<HealthOutOfBoundTamagotchiException> {
                repeat(BoundedLimits.Tamagotchi.UP_LIMIT + 1) { tamagotchi.play() }
            }
        }

        @Test
        fun `should verify happiness and health are decremented when called play`() {
            val tamagotchi = Tamagotchi(tamagotchiName)
            val happiness = tamagotchi.happiness
            val health = tamagotchi.health
            tamagotchi.play()
            assertEquals(happiness + Play.HAPPINESS, tamagotchi.happiness)
            assertEquals(health + Play.HEALTH, tamagotchi.health)
        }
    }
}

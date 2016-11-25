package chp02.color

import color.Color.*
import color.getMnemonic
import color.getWarmth
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by AidenChoi on 2016. 11. 25..
 */
class ColorTest {

    @Test
    fun mnemonic() {
        assertEquals("York", getMnemonic(YELLOW))
    }

    @Test
    fun warmth() {
        assertEquals("cold", getWarmth(INDIGO))
    }

    @Test
    fun mix() {
        assertEquals(GREEN, color.mix(BLUE, YELLOW))
        assertEquals(GREEN, color.mixOptimized(BLUE, YELLOW))
    }
}
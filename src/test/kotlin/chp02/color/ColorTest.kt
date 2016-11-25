package chp02.color

import chp02.color.Color.*
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
        assertEquals(GREEN, mix(BLUE, YELLOW))
        assertEquals(GREEN, mixOptimized(BLUE, YELLOW))
    }
}
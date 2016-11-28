package chp02

import chp02.Color.*
import chp02.getMnemonic
import chp02.getWarmth
import chp02.mixOptimized
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
        assertEquals(GREEN, chp02.mix(BLUE, YELLOW))
        assertEquals(GREEN, mixOptimized(BLUE, YELLOW))
    }
}
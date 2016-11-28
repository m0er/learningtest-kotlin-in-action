package chp02

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * Created by AidenChoi on 2016. 11. 28..
 */
class FizzBuzzTest {

    @Test
    fun fizzBuzz() {
        assertEquals(fizzBuzz(3).trim(), "Fizz")
        assertEquals(fizzBuzz(5).trim(), "Buzz")
        assertEquals(fizzBuzz(15).trim(), "FizzBuzz")
        assertEquals(fizzBuzz(19).trim(), "19")

        for (i in 20 downTo 1 step 2) {
            print(fizzBuzz(i))
        }
    }

    @Test
    fun iteratingOverMaps() {
        val binaryReps = TreeMap<Char, String>()

        for (c in 'A'..'F') {
            val binary = Integer.toBinaryString(c.toInt())
            binaryReps[c] = binary
        }

        for ((letter, binary) in binaryReps) {
            println("$letter = $binary")
        }
    }

    @Test
    fun trackOfIndex() {
        val list = arrayListOf("10", "11", "1001")
        for ((index, element) in list.withIndex()) {
            println("$index: $element")
        }
    }
}
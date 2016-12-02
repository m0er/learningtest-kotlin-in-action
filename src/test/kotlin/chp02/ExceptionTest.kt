package chp02

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by AidenChoi on 2016. 11. 30..
 */
class ExceptionTest {

    @Test
    fun percentage_between_0_and_100() {
        percentage(50)
    }

    @Test(expected = IllegalArgumentException::class)
    fun percentage_over_100() {
        percentage(300)
    }

    @Test
    fun readCorrectNumber() {
        val line = readNumber(BufferedReader(StringReader("239")))
        assertNotNull(line)
    }

    @Test
    fun readNotANumber() {
        assertNull(readNumber(BufferedReader(StringReader("not a number"))))
    }

    @Test
    fun readCorrectNumber2() {
        val line = readNumber2(BufferedReader(StringReader("239")))
        assertNotNull(line)
    }

    @Test
    fun readNotANumber2() {
        assertNull(readNumber2(BufferedReader(StringReader("not a number"))))
    }

    @Test
    fun readCorrectNumber3() {
        assertNotNull(readNumber3("239"))
    }

    @Test(expected = NumberFormatException::class)
    fun readNotANumber3() {
        assertNull(readNumber3("not a number"))
    }
}
package chp02

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Created by AidenChoi on 2016. 11. 24..
 */
class LearningTest {

    @Test
    fun helloWorld() {
        println("Hello, world!")
    }

    @Test
    fun maxTest() {
        assertEquals(100, max(10, 100))
    }

    fun max(a: Int, b: Int) = if (a > b) a else b
}
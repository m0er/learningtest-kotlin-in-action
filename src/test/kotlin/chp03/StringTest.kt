package chp03

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by AidenChoi on 2016. 12. 1..
 */
class StringTest {

    @Test
    fun split() {
        val testString = "12.345-6.A"
        assertEquals(4, testString.split("\\.|-".toRegex()).size)
        assertEquals(4, testString.split(".", "-").size)
    }

    @Test
    fun substring() {
        val (directory, fileName, extension) = parsePath("/Users/aidenchoi/kotlin-book/chapter.adoc")
        assertEquals("/Users/aidenchoi/kotlin-book", directory)
        assertEquals("chapter", fileName)
        assertEquals("adoc", extension)
    }
}
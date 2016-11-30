package chp03

import org.junit.Assert.assertEquals
import org.junit.Test
import strings.joinToString

/**
 * Created by AidenChoi on 2016. 11. 30..
 */
class CollectionTest {

    @Test
    fun create() {
        val set = setOf(1, 7, 53)
        val list = listOf(1, 7, 53)
        val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        println(set.javaClass)
        println(list.javaClass)
        println(map.javaClass)
    }

    @Test
    fun extensionFuns() {
        val strings = listOf("first", "second", "fourteenth")
        assertEquals("fourteenth", strings.last())
        assertEquals("first", strings.first())

        val numbers = setOf(1, 14, 2)
        assertEquals(14, numbers.max())
    }

    @Test
    fun joinToString() {
        val list = listOf(1, 2, 3)
        assertEquals("1, 2, 3", joinToString(list))
        assertEquals("(1; 2; 3)", joinToString(list, separator = "; ", prefix = "(", postfix = ")"))
        assertEquals("# 1, 2, 3", joinToString(list, prefix = "# "))
    }
}
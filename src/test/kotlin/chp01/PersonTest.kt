package chp01

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by AidenChoi on 2016. 11. 24..
 */
class PersonTest {
    var persons = listOf(Person("Alice"), Person("Bob", age = 29))

    @Test
    fun findOldestPerson() {
        val oldest = persons.maxBy { it.age ?: 0 }
        println("The oldest is: $oldest")

        assertEquals("Bob", oldest?.name)
    }

    @Test
    fun findNamedAlice() {
        val alice = findAlice()
        assertEquals("Alice", alice?.name)
    }

    private fun findPerson(condition: (Person) -> Boolean): Person? {
        return persons.find(condition)
    }

    private fun findAlice() = findPerson { it.name == "Alice" }
}
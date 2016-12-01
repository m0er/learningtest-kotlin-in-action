package chp03

import org.junit.Assert.assertEquals
import org.junit.Test
import strings.*
//import strings.lastChar as last

/**
 * Created by AidenChoi on 2016. 11. 30..
 */
class ExtensionFunctionTest {

    @Test
    fun lastChar() {
        assertEquals('n', "Kotlin".lastChar())

        val sb = StringBuilder("Kotlin?")
        sb.lastChar = '!'
        assertEquals('!', sb.toString().lastChar())
    }

    @Test
    fun overrideFunction() {
        val view: View = Button()
        view.click()
        view.showOff()
    }
}
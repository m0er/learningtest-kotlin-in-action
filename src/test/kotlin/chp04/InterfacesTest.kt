package chp04

import org.junit.Test

/**
 * Created by AidenChoi on 2016. 12. 2..
 */
class InterfacesTest {

    @Test
    fun multipleInheritance() {
        val button = Button()
        button.showOff()
        button.setFocus(true)
        button.click()
    }
}
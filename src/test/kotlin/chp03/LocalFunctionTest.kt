package chp03

import org.junit.Test

/**
 * Created by AidenChoi on 2016. 12. 2..
 */
class LocalFunctionTest {

    @Test(expected = IllegalArgumentException::class)
    fun saveUser() {
        chp03.saveUser(User(1, "", ""))
    }
}
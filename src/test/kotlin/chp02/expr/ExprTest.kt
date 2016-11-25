package chp02.expr

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by AidenChoi on 2016. 11. 25..
 */
class ExprTest {

    @Test
    fun expr() {
        assertEquals(7, eval(Sum(Sum(Num(1), Num(2)), Num(4))))

        assertEquals(7, eval2(Sum(Sum(Num(1), Num(2)), Num(4))))

        assertEquals(7, eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
    }
}
package chp02

import java.util.*

/**
 * Created by AidenChoi on 2016. 11. 25..
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
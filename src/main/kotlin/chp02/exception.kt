package chp02

import java.io.BufferedReader

/**
 * Created by AidenChoi on 2016. 11. 30..
 */
fun percentage(number: Int) {
    val percentage =
        if (number in 0..100)
            number
        else
           throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
    println("Initialized percentage value: $percentage")
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) = try {
        Integer.parseInt(reader.readLine())
    } catch (e:NumberFormatException) {
        null
    }
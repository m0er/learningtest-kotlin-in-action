package chp03

/**
 * Created by AidenChoi on 2016. 11. 30..
 */

// package-level
var opCount = 0

// public static final
const val UNIX_LINE_SEPARATOR = "\n"

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}
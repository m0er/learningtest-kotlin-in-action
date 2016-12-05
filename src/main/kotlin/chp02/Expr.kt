package chp02

/**
 * Created by AidenChoi on 2016. 11. 25..
 */
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int {
    if (e is Expr.Num) {
        val n = e as Expr.Num
        return n.value
    } else if (e is Expr.Sum) {
        return eval(e.right) + eval(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }
}

fun eval2(e: Expr): Int =
    if (e is Expr.Num) {
        e.value
    } else if (e is Expr.Sum) {
        eval2(e.right) + eval2(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun eval3(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval3(e.right) + eval3(e.left)
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Expr.Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Expr.Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum $left + $right = ${left + right}")
            left + right
        }
    }
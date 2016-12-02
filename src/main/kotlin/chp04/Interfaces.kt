package chp04

/**
 * Created by AidenChoi on 2016. 12. 2..
 */
interface Clickable {

    // abstract, open
    fun click()

    // open
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

// final class
class Button : Clickable, Focusable {

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() = println("I was clicked")
}

open class RichButton : Clickable {

    // final function
    fun disable() {}

    // can override it in a subclass
    open fun animate() {}

    // overrides an open function and its open as well.
    override fun click() {}

    // forbid overriding
//    final override fun click() {}

}

// Abstract members are always open.
abstract class Animated {

    // must be overridden
    abstract fun animate()

    // can override on subclass
    open fun stopAnimating() {}

    // final
    fun animateTwice() {}
}

class DummyAnimated : Animated() {

    override fun animate() {

    }

    // optional
    override fun stopAnimating() {
        super.stopAnimating()
    }

}
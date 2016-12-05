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

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

/**
 * 1. internal 스콥인데 퍼블릭 메소드 만들어서 에러.
 * 2. yell() 메소드는 private 이라서 같은 클래스에서만 호출 가능.
 * 3. whisper() 메소드는 protected 여서 같은 클래스나 상속 받은 클래스에서 호출 가능.
 *
 * 확장 함수는 private, protected 멤버에 접근 할 수 없음.
 */
//fun TalkativeButton.giveSpeech() {
//
//    yell()
//
//    whisper()
//}
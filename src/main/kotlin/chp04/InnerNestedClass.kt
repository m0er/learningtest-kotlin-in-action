package chp04

import java.io.Serializable

/**
 * Created by AidenChoi on 2016. 12. 5..
 */
interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class ButtonView : View {

    override fun getCurrentState(): State = ButtonViewState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    // 코틀린 내부 클래스는 외부 클래스를 참조하지 않는다.
    class ButtonViewState : State {

        fun test() {
            // Unresolved reference
//            getCurrentState()
        }
    }
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
package chp04

/**
 * Created by AidenChoi on 2016. 12. 5..
 */

// primary 생성자 선언 및 부모 클래스의 생성자 호출.
open class User(val nickname: String) {}
class TwitterUser(nickname: String) : User(nickname) {}

// 상속을 받을 때 () 를 붙여야 하는 이유는 부모 클래스의 생성자 호출을 위함.
// 인터페이스는 생성자가 없어 호출하지 않음.
open class BaseButton
class RadioButton : BaseButton()

// 인스턴스 생성을 막기 위한 private 생성자 선언:
class Secretive private constructor()

class Secretive2 {
    private constructor()
}

// 두 개의 secondary 생성자.
open class BaseView {
    constructor(ctx: Context) {
        // ...
    }

    constructor(ctx:Context, attr: AttributeSet) {
        // ...
    }
}

private val MY_STYLE: AttributeSet = AttributeSet()
class MyButton : BaseView {

    constructor(ctx: Context) : this(ctx, MY_STYLE) {
        // ...
    }

    constructor(ctx:Context, attr: AttributeSet) : super(ctx, attr) {
        // ...
    }
}

open class Context
open class AttributeSet

package thirdUnit

import java.io.Serializable

/*
* 修饰符                 类成员                    顶层说明
* public             所有地方可见                所有地方可见
* internal            模块中可见                  模块中可见
* protected            子类可见                     ——
* private              类中可见                   文件中可见
* */

internal open class TalkativeButton: Focusable{
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

internal fun TalkativeButton.giveSpeech(){ //必须使用internal不能不写，因为这样会暴露其internal接收者类型的TalkativeButton
    //yell()      不能访问yell()，因为他在TalkativeButton中是private类型
    //whisper()      不能访问whisper()，因为他在TalkativeButton中是protected类型
}

interface State: Serializable

interface View{
    fun getCurrentState(): State
    fun restoreState(state: State){}
}
/*嵌套类和内部类在Java与Kotlin中的对应关系
类A在另一个B类中声明               在Java中            在Kotlin中
嵌套类（不存储外部类的引用）     static class A          class A
内部类（存储外部类的引用）           class A          inner class A
*/
class Button1: View{
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {

    }

    class ButtonState: State{    //嵌套类

    }
}

class Outer{
    inner class Inner{
        fun getOuterReference(): Outer = this@Outer
    }
}


package secondUnit;

open class View{
        open fun onclick() = println("view clicked!")
}

class Button: View(){
        override fun onclick() = println("button clicked!")
}
//拓展属性，必须自定义一个getter函数，因为没有默认getter实现
//初始化也不可以，因为无处存放初始值
val String.lastChar: Char get() = get(length - 1)

var StringBuilder.lastChar: Char
        get() = get(length - 1)
        set(value) {
                this.setCharAt(length - 1 , value)
        }

fun main(){
        val list = listOf(1,7,53)
        println(list.joinToString2(prefix = "{", postfix = "}"))
        val view: View = Button()
        //打印I'm a view！,拓展函数被静态解析
        //当拓展函数和成员函数重名时，成员函数优先使用！
        view.showOff()
        println("Kotlin".lastChar)
        val sb = StringBuilder("Kotlin?")
        sb.lastChar = '!'
        println(sb)
}

fun View.showOff() = println("I'm a View!")
fun Button.showOff() = println("I'm a Button!")

fun <T> Collection<T>.joinToString2(
        separator: String = ", ",
        prefix: String = " ",
        postfix: String = " "
        ): String {
        val result = StringBuilder(prefix)
        for((index,element) in this.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)
        }

        result.append(postfix)
        return result.toString()
}

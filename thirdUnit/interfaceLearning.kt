package thirdUnit

interface Clickable{
    fun click()
    fun showOff() = println("I'm clickable!")
}

//在接口中声明一个抽象属性
interface KotlinUser{
    val nickName: String//必须在子类中重写
    val email:String get() = "$nickName@qq.com"//子类可以继承父类的
}

fun PublicUser.getPublicName(accountId: Int) = accountId.toString()

class PrivateUser(override val nickName: String):KotlinUser //主构造方法属性

class SubscribingUser(val emails: String) : KotlinUser{      //自定义getter
    override val nickName: String
        get() = email.substringBefore("@")
}

class PublicUser(val accountId: Int) : KotlinUser{          //属性初始化
    override val nickName: String = getPublicName(accountId)
}

interface Focusable{
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

//一个类可以实现多个接口，但是只能继承一个类
class Button: Clickable, Focusable{
    //kotlin中重写一个方法使用override修饰符是强制的
    override fun click() {
        println("button is clicked!")
    }
    //如果一个类实现具有相同函数的两个借口，必须提供一个显示实现
    override fun showOff(){
        //需要调用的基类的名字放在super后的<>内
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(){
    val button = Button()
    button.click()
    button.setFocus(true)
    button.showOff()
}

//没有特别需要在子类中被重写的类和方法应该显示标注为final
open class RichButton: Clickable{    //这个类是open的，其他类可以继承
    fun disable(){}                 //这个方法是final的:不能在子类中重写

    open fun animate(){}            //这个类是open的：可以在子类中重写

    override fun click(){}          //这个函数是重写了一个open的函数，并其本身也是open的
}

abstract class Animated{

    abstract fun animate()          //abstract的函数必须被子类重写

    open fun stopAnimating(){       //抽象类中的非抽象函数并非默认open的，但可以标注为open

    }

    fun animateTwice(){}
}
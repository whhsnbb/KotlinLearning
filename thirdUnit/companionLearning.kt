package thirdUnit

//伴生对象在子类中不能被重写
//使用 companion 关键字修改的对象之后，伴生对象就相当于是外部类的对象
//伴生对象的主要作用就是为其所在的外部类模拟静态成员。
//因为 Kotlin 取消了 static 关键字，所以 Kotlin 引入伴生对象来弥补没有静态成员的不足。
class A{
    companion object{
        val flag = false
        fun plus(num1: Int, num2: Int) : Int = num1 + num2
    }
}

class UserC{
    val name: String

    constructor(email: String){
        name = email.substringBefore("@")
    }

    constructor(faceBookAccountId: Int){
        name = "$faceBookAccountId@qq.com"
    }
}

//以上代码可以用伴生对象代替，使用工厂方法代替构造方法
class UserB private constructor(val name: String){
    companion object{
        fun newSubScribingUser(email: String) = UserB(email.substringBefore("@"))

        fun newFaceBookUser(faceBookAccountId: Int) = UserB("$faceBookAccountId@qq.com")
    }
}

//伴生对象可以实现接口
interface JSONFactory<T>{
    fun fromJASON(jsonText: String) : T
}

//为伴生对象拓展函数
fun Person3.Companion.getName() : String = Person3("wjx").name

class Person3(val name: String){
    companion object : JSONFactory<Person3>{
        override fun fromJASON(jsonText: String): Person3 = Person3(jsonText)
    }
}

fun loadFromJSON(factory: JSONFactory<Person3>) : String{
    return Person3("whh").name
}

fun main(){
    println(A.flag)
    println(A.plus(1,2))

    val subscribingUser = UserB.newSubScribingUser("bob@qq.com")
    val faceBookUser = UserB.newFaceBookUser(1144320036)
    println(subscribingUser.name)
    println(faceBookUser.name)

    println(loadFromJSON(Person3))
    val string = Person3.getName()
    println(string)
}
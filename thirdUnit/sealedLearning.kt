package thirdUnit

sealed class Expr{
    class Num(val value: Int) : Expr()//继承Expr类，所以Expr后有括号
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when(e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.left) + eval(e.right)
        //因为Expr是密封类，所以Expr在类外部不能拥有子类，所以when就不用拥有else分支了
    }

//field 标识符只能用在属性的访问器内。
//在setter中访问支持字段
class UserN(val name: String){
    var address: String = "undefined"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".
            """.trimIndent())
            field = value       //field 标识符只能用在属性的访问器内。下次setter访问到的就是field值
        }
}

fun main(){
    val user = UserN("Alice")
    user.address = "翻斗花园"
    println(user.address)

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

class LengthCounter{
    var counter: Int = 0
        private set         //不能在类外部修改counter属性，因为他的构造器是private的
    fun addWord(word: String){
        counter += word.length
    }
}
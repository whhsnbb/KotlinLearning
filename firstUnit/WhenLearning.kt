package firstUnit
interface Expr
class Num(val value: Int) : Expr
class Sum(val left : Expr, val right: Expr) : Expr

/*fun eval(e: Expr) : Int {
    //is用来判断一个变量是否是某种类型，和java的instanceOf()相似，is判断后，会自动转换类型
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalAccessException("Unknown expression")
}*/

fun eval(e: Expr) : Int =
    when(e){
        //is如果判断成功，就会智能转换
            //代码块最后是返回值，相当于return
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val right = eval(e.right)
            val left = eval(e.left)
            println("sum: $right + $left")
            right + left
        }
        else -> throw IllegalAccessException("unknown expression")
    }

fun main(){
    println(eval(Sum(Sum(Num(1),Num(2)),Num(3))))
}
package secondUnit

import java.util.*

//中缀调用可以与只有一个参数的函数一起使用；若允许使用中缀符号调用函数，需要用infix标记该函数
infix fun Any.to(other: Any) = Pair(this,other)
val stringSet: List<String> = listOf("one", "two", "fourteenth")
val numberSet: Collection<Int> = setOf(1, 5, 63)
//使用中缀符to可以调用to函数，java中是1.to("one")
val numberMap = mapOf(1 to "one", 2 to "two", 14 to "fourteen")
val array: Array<String> = arrayOf("one", "two", "fourteenth")

fun main(){
    println(stringSet.last())
    println(numberSet.maxOrNull())
    //可以通过*字符展开一个数组并引入到有可变参数的函数中
    val list = listOf("args: ", *array)
    println(list)
    val (number, name) = 1 to "one"
    for((index, value) in numberMap){
        println("$index: $value")
    }
}


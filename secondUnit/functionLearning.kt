package secondUnit

import java.lang.StringBuilder

//顶层属性，相当于java中的静态属性,通过访问器（val只有getter，var有getter和setter）暴露给java使用
var count = 0
val list = arrayListOf(1,7,53)
//用const修饰相当于public static final
const val UNIX_LINE_SEPARATOR = "\n"
//顶层函数，相当于java中类的静态方法
fun performOperation(){
    count++
}
//为String类拓展函数，拓展函数相当于java中的静态函数，但是拓展函数不能访问String类里的私有和受保护成员
//若java想调用此函数，char c = functionLearningKt.lastChar("Java");
fun String.lastChar(): Char = get(length - 1)

fun main(){
    //直接打印相当于调用list.toString()
    println(list)
    //少写的参数就是调用了默认的参数
    println(joinToString(list))
    //kotlin支持在调用函数时标明参数的名称，方便coder了解函数意义
    println(joinToString(list, separator = "; ", prefix = "[", postfix = "]"))
    //当以命名参数形式调用函数时，可以任意省略某个参数,且参数位置不限制
    println(joinToString(list, postfix = "}", prefix = "{"))
    performOperation()
    println(count)
    println("Kotlin".lastChar())
}

//函数可以带默认值
fun joinToString(
    collection: Collection<*>,
    separator: String = ", ",
    prefix: String = " ",
    postfix: String = " "
): String {
    val result = StringBuilder(prefix)
    for((index,element) in collection.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}
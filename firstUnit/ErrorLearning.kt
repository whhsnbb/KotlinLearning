package firstUnit

import secondUnit.lastChar as last
import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

var number = 98
val c = "java".last()
var percentage =
    if(number in 0..100)
        number
    else
        throw IllegalAccessException("$number is not in 0..100")

fun main(){
    println(percentage)
    println(readNumber(BufferedReader(StringReader("236"))))
}

fun readNumber(reader: BufferedReader) {
    //try也可以当表达式用
    val number = try{
        Integer.parseInt(reader.readLine())
    }catch (e: NumberFormatException){
        return
    }

    println(number)
}
package firstUnit

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val binaryReps = TreeMap<Char, String>()
    val list = arrayListOf("10","100","1000")

    for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        //等价binaryReps.put(c,binary)
        //kotlin是map[key] = value,不需要调用get 和 put
        binaryReps[c] = binary
    }

    for ((letter,binary) in binaryReps){
        println("$letter = $binary")
    }

    for((index,element) in list.withIndex()){
        println("$index: $element")
    }
}
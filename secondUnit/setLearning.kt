package secondUnit

val set = hashSetOf(1,7,53)
val map = hashMapOf(1 to "one", 7 to "seven", "53" to "fifty-three")

val strings = listOf("first","second","fourteenth")
val numbers = setOf(1,14,6)
fun main(){
    println(strings.last())
    println(numbers.maxOrNull())
    //.javaClass相当于java的getClass()
    println(set.javaClass)
}
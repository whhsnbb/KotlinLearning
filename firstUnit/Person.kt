package firstUnit

class Person (
    val name: String,
    var isMarried: Boolean,
    var age: Int
){
    val isAdult: Boolean
        get() = age>18
}

fun main(){
    val person = Person("whh", false, 20)
    println(person.name)
    println(person.isMarried)
    println(person.isAdult)
    person.age = 17
    println(person.isAdult)
}
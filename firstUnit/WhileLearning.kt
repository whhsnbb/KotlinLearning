package firstUnit

fun fizzBuzz( i : Int) =
    when{
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }

fun main(){
    //..语法包括区间的两个端点
    for (i in 1..10) {
        var unit = Unit
        println(fizzBuzz(i))
    }
    //从100倒数，每次间隔为2
    for(i in 100 downTo 0 step 2){
        println(i)
    }
}
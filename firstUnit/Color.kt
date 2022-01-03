package firstUnit
import firstUnit.Color.*
import java.lang.Exception

enum class Color(
    var r: Int,
    var g: Int,
    var b: Int) {
    RED(255,0,0),ORANGE(255,165,0),
    YELLOW(255,255,0),GREEN(0,255,0),
    BLUE(0,0,255),INDIGO(75,0,130),VIOLET(238,130,238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main(){
    println(BLUE.rgb())
    println(getMnemonic(RED,ORANGE))
}

fun getMnemonic(color1: Color, color2: Color) =
    when(setOf(color1, color2)){
        setOf(RED, ORANGE) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty Color")
    }


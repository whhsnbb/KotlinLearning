package thirdUnit

//系统自动重写了equals，toString，hashCode
//data类新增copy方法,实现如下
//class Data(val name: String, val postalCode: Int){
//    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Data(name, postalCode)
//}
data class Data(val name: String, val postalCode: Int)

fun main(){
    val data = Data("Alice",32645)
    println(data.copy("Bob"))
}
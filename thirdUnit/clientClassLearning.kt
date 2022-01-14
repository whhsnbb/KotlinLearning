package thirdUnit
//Kotlin中==相当于equals()，用于比较两个值是否相等，如果只想比较引用是否一样可以使用===
class Client(val name: String, val postalCode: Int) {
//    override fun toString(): String = "Client(name = $name, postalCode = $postalCode)"
//
//    override fun equals(other: Any?): Boolean {
//        if(other == null || other !is Client){
//            return false
//        }
//        return name == other.name && postalCode == other.postalCode
//    }
//
//    override fun hashCode(): Int =
//        name.hashCode() * 31 + postalCode
}

fun main(){
    val client1 = Client("Alice",342562)
    val client2 = Client("Alice",342562)
    println(client1)
    println(client1 == client2)
    val processed = hashSetOf(Client("Alice",342562))
    println(processed.contains(Client("Alice",342562)))//如果不重写hashCode，返回值为false，
    // 因为Client不同实例有着不同的hash值，所以set认为它不包含第二个对象，即使equals重写返回true，但他俩得hashCode仍然不同

}
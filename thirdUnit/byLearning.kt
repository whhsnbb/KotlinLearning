package thirdUnit

//如果不适用by就需要重写很多方法才能完成这些功能
class DelegatingCollection<T> : Collection<T>{
    private val innerList = arrayListOf<T>()

    override val size: Int
        get() = innerList.size

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()

    override fun contains(element: T): Boolean = innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
}

//by关键字可以吧一个接口委托给另一个对象，这样就不用重写但是还可以使用这些方法
class DeleteCollection<T>(innerList : Collection<T> = ArrayList<T>()) : Collection<T> by innerList{}

class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet{
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main(){
    val set = CountingSet<Int>()
    set.addAll(listOf(1,2,3))
    println("${set.objectsAdded} objects were added, ${set.size} remain")
}
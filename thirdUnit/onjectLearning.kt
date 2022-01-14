package thirdUnit

import firstUnit.Person
import java.io.File

//object对象声明，适用于单例模式
//同样可以继承类和接口
object Payroll{
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary(){
        for(person in allEmployees){
            println(person.age)
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File>{
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path,ignoreCase = true)
    }
}

data class Person1(val name: String){
    object NameComparator : Comparator<Person1>{
        override fun compare(o1: Person1, o2: Person1): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main(){
    Payroll.allEmployees.add(Person("Alice",isMarried = false,36))
    Payroll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("/User"),File("/user")))
    val files = listOf(File("/z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))//这里需要一个比较器对象
    // 我们object声明的单例对象，可以在任何使用普通对象得地方使用它

    val persons = listOf(Person1("Bob"),Person1("Alice"))
    println(persons.sortedWith(Person1.NameComparator))
}
package secondUnit

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User){
    //局部函数可以直接访问外部函数的参数
    fun validate(value:String, fileName: String){
        if(value.isEmpty()){
            throw IllegalAccessException("Can't save user ${user.id}: Empty $fileName!")
        }
    }

    validate(user.name,"name")
    validate(user.address, "address!")

    //保存逻辑（未写）
}

fun main(){
    saveUser(User(1, "", ""))
}
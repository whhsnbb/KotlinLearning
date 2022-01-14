package thirdUnit

import javax.naming.Context
import javax.swing.text.AttributeSet

open class User(val name: String)//val意味着相应的属性会用构造方法的参数来初始化

class User1 constructor(_nickName: String){
    val nickName: String

    init {
        nickName = _nickName
    }
}

class User2(_nickName: String){
    val nickName = _nickName
}

//如果一个类拥有父类，主构造方法同时需要初始化父类。可以在基类列表的父类引用中提供父类构造方法参数的方式来做到这一点，如下：
class TwitterUser(nickName: String) : User(nickName){

}

open class UserButton     //如果一个类没声明任何构造方法，将会生成一个空参构造方法

class RadioButton: UserButton()

//确保一个类不想被实例化，就可以私有化它的主构造方法，这种类常常是工具类
class Secretive private constructor(){

}

//这个类没有主构造方法，丹有两个从构造方法，使用constructor引出从构造方法
open class MyView{
    constructor(ctx: Context){

    }

    constructor(ctx: Context, name: String){

    }
}

class MyButton: MyView{
    constructor(ctx: Context) : this(ctx, "null"){//调用this关键字，可以调用同一类的另一个构造方法

    }

    constructor(ctx: Context, name: String) : super(ctx,name){//调用super关键字，可以调用父类的构造方法

    }
}


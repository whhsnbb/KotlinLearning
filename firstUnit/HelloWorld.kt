fun main(args:Array<String>){
     println("Hello World")
     println(max(2,3))
 }

 fun max(a: Int, b: Int) : Int{
     return if(a>b) a else b;
 }
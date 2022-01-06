package secondUnit

//多行三重引号，不用避免转义字符，它可以包含所有字符包括换行符，多用于测试
const val kotlinLogo = """| //
                   .|//
                   .|/ \"""

fun main(){
    //toRegex()显示创建一个正则表达式，以下两个都是匹配分割"."和"-"
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".","-"))
    javaParsePath("C:/Users/王航No·1/AppData/Roaming/Tencent/QQMicroGameBox/Launch.exe")
    kotlinParsePath("C:/Users/王航No·1/AppData/Roaming/Tencent/QQMicroGameBox/Launch.exe")
    //trimMargin函数去除了每行前面前缀”.“和空格
    println(kotlinLogo.trimMargin("."))
}

fun javaParsePath(path: String){
    //获得最后一个"/"前的内容
    val directory = path.substringBeforeLast("/")
    //获得最后一个"/"后的内容
    val fullName = path.substringAfterLast("/")
    //fullName是整个文件的文件名，分为名字和类型,"."前是名字，"."后是类型
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun kotlinParsePath(path: String){
    //(.+)/(.+)\.(.+)第一个括号代表文件名，第二个括号代表文件名，第三个代表文件类型
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    ///匹配成功则不为null，打印即可，匹配不成功结果为null
    if(matchResult != null){
        val(directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}
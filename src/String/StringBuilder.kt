package String

fun main() {


    val stringBuilder = StringBuilder()
    println("String builder : ${stringBuilder.capacity()}")
    println("Length : ${stringBuilder.length}")

    stringBuilder.append("Hello")
    println("String builder : ${stringBuilder.capacity()}")
    println("Length : ${stringBuilder.length}")

    stringBuilder.append("Kotlin is awesome!")
    println("String builder : ${stringBuilder.capacity()}")
    println("Length : ${stringBuilder.length}")
    println(stringBuilder)


//    val stringBuffer = StringBuffer()
//    println("String buffer : ${stringBuffer.capacity()}")
}
package december


/**
 *
 *  If we list all the natural numbers below 10
 *  that are multiples of 3 or 5 , we get 3,5,6 and 9
 *  and The sum of these multiples is 23.
 *
 *  Find the sum of all the multiples of 3 or 5 below 100
 *
 * */


fun multiply(number : Int) : Int{

    var sum = 0

    for (i in 1..<number){
        if (i % 3 == 0 || i % 5 == 0){
            sum += i
        }
    }
    return  sum
}

fun main() {

    val number = 100
    println("The sum of all multiples of 3 or 5 below $number : ${multiply(number)}.")
}
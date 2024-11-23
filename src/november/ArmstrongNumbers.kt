package november

import kotlin.math.pow

/**
 *
 * Instructions
 * An Armstrong number is a number that is the sum of its own digits
 * each raised to the power of the number of digits.
 *
 * For example:
 *
 * 9 is an Armstrong number, because 9 = 9^1 = 9
 * 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 * 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
 * Write some code to determine whether a number is an Armstrong number.
 *
 * */

// 123 -> [123] -> size 3

fun armStrongNumber(numbers : Int) : Boolean {

    //convert the number to a string to get each digit
    val digits = numbers.toString().map { it.toString().toInt() }
    val numberOfDigits = digits.size
    //Calculate the Sum of Powers
    val sum = digits.sumOf { digit -> digit.toDouble().pow(numberOfDigits).toInt() }
    return sum == numbers
}

fun main() {

    for (index in 1..10000){
        val armStrongNumber = armStrongNumber(index)
        if (armStrongNumber) {
            println("$index is an Armstrong number.")
        }
    }

}
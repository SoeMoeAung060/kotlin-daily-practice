package december

import kotlin.math.pow
import kotlin.math.sqrt


/**
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2,
 *
 * the first 10 terms will be:
 *  1,2,3,5,8,13,21,34,55,89...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 *
 *
 * */
fun fibonacci(n : Int) : Int{

    val pai = 1.61803398875
    val sqrt5 = sqrt(5.0)
    return ((pai.pow(n) - ( 1 - pai).pow(n)) / sqrt5).toInt()

}

fun sumOfEvenFibonacci(limitNumber: Int) : Int{

    var sum = 0
    var n = 1
    val fibonacciNumber = mutableListOf<Int>()

    while(true){
        val fib = fibonacci(n)
        if (fib > limitNumber) break
        fibonacciNumber.add(fib)
        if (fib % 2 == 0) sum += fib
        n++
    }

    println("Fibonacci Sequence up to : $limitNumber")
    println(fibonacciNumber.joinToString(", "))

    return sum
}

fun main() {
    val limit = 4000000
    println("Sum of even Fibonacci numbers below $limit using the golden ratio: ${sumOfEvenFibonacci(limit)}")
}
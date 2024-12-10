package december

import kotlin.math.sqrt

/**
 *
 * Instructions
 * Write a function that returns the earned points in a single toss of a Darts game.
 *
 * Darts is a game where players throw darts at a target.
 *
 * In our particular instance of the game, the target rewards
 * 4 different amounts of points, depending on where the dart lands:
 *
 * Our dart scoreboard with values from a complete miss to a bullseye
 *
 * If the dart lands outside the target, player earns no points (0 points).
 * If the dart lands in the outer circle of the target, player earns 1 point.
 * If the dart lands in the middle circle of the target, player earns 5 points.
 * If the dart lands in the inner circle of the target, player earns 10 points.
 *
 * The outer circle has a radius of 10 units (this is equivalent to the total radius
 * for the entire target), the middle circle a radius of 5 units, and the inner circle a radius of 1.
 * Of course, they are all centered at the same point — that is,
 * the circles are concentric defined by the coordinates (0, 0).
 *
 * Write a function that given a point in the target (defined by its Cartesian
 * coordinates x and y, where x and y are real), returns the correct amount earned by a dart landing at that point.
 *
 * */


fun score(x2 : Double, y2: Double) : Int{

    // Define the center of the target
    val x1 = 0.0
    val y1 = 0.0

    // Apply the distance formula: d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
    val distance = sqrt((x2-x1) * (x2-x1) + (y2 - y1) * (y2-y1))

    // Determine the score based on the distance
    return when{
        distance > 10 -> 0
        distance > 5 -> 1
        distance > 1 -> 5
        else -> 10
    }

}

fun main() {

    println(score(0.0, 1.0))
    println(score(10.0, 0.0))
    println(score(5.4, 13.4))
    println(score(1.4, 4.2))
}
package november

import kotlin.random.Random
import kotlin.random.nextInt

/**
 * For a game of Dungeons & Dragons,
 * each player starts by generating a character they can play with.
 * This character has, among other things,
 * six abilities; strength, dexterity, constitution, intelligence, wisdom and charisma.
 *
 * These six abilities have scores that are determined randomly.
 * You do this by rolling four 6-sided dice and recording the sum of the largest three dice.
 * You do this six times, once for each ability.
 *
 * Your character's initial hitpoints are 10 + your character's constitution modifier.
 * You find your character's constitution modifier by subtracting 10
 * from your character's constitution, divide by 2 and round down.
 *
 * */
class DndCharacters {

    // Ability scores are generated using the `ability` function
    val strength : Int = ability()
    val dexterity : Int = ability()
    val constitution: Int = ability()
    val intelligence : Int = ability()
    val wisdom : Int = ability()
    val charisma : Int = ability()

    // Hitpoints are calculated based on the constitution modifier
    val hitpoints : Int = 10 + modifier(constitution)

    companion object{
        // Generate an ability score by rolling 4 dice and summing the highest 3
        fun ability() : Int {
            return List(4) {Random.nextInt(1..6)}.sortedDescending().take(3).sum()
        }

        // Calculate the modifier for a given score
        fun modifier(score : Int) : Int {
            return (score - 10) / 2
        }
    }

}

fun main() {

    val dndCharacters = DndCharacters()
    println("Strength : ${dndCharacters.strength}")
    println("Dexterity : ${dndCharacters.dexterity}")
    println("Constitution : ${dndCharacters.constitution}")
    println("Intelligence : ${dndCharacters.intelligence}")
    println("Wisdom : ${dndCharacters.wisdom}")
    println("Charisma : ${dndCharacters.charisma}")
    println("Hitpoints : ${dndCharacters.hitpoints}")
}


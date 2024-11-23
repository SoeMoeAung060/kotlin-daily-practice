package november

/**
 * Instructions
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts
 * a long name like Portable Network Graphics to its acronym (PNG).
 *
 * Punctuation is handled as follows: hyphens are word separators (like whitespace);
 * all other punctuation can be removed from the input.
 *
 * For example:
 *
 * Input	                            Output
 * As Soon As Possible	                ASAP
 * Liquid-crystal display	            LCD
 * Thank George It's Friday!	        TGIF
 *
 * */

fun generateAcronym(phrase : String) : String {

    println("Input: $phrase")
    // Replace hyphens with spaces
    val normalizePhrase = phrase.replace("-", " ")
    // Remove all other punctuation using Regex
    val cleanPhrase = normalizePhrase.replace(Regex("[^a-zA-Z\\s]"), " ")
    // Remove empty words
    val words = cleanPhrase.split(" ").filter { it.isNotBlank() }
    // Extract first Character
    val firstLetter = words.map { it[0] }
    val upperCase = firstLetter.joinToString("").uppercase()

    return upperCase
}


fun main() {
    val phrase1 = generateAcronym("Liquid-crystal_display!@")
    val phrase2 = generateAcronym("As Soon As Possible")
    println("Output : $phrase1")
    println("Output : $phrase2")
}
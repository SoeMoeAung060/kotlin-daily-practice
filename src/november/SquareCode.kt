package november

import kotlin.math.ceil
import kotlin.math.sqrt


/**
 *
 * Instructions
 * Implement the classic method for composing secret messages called a square code.
 *
 * Given an English text, output the encoded version of that text.
 *
 * First, the input is normalized: the spaces and punctuation are removed from the English text and the message is down-cased.
 *
 * Then, the normalized characters are broken into rows. These rows can be regarded as forming a rectangle when printed with intervening newlines.
 *
 * For example, the sentence
 *
 * "If man was meant to stay on the ground, god would have given us roots."
 * is normalized to:
 *
 * "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"
 * The plaintext should be organized into a rectangle as square as possible. The size of the rectangle should be decided by the length of the message.
 *
 * If c is the number of columns and r is the number of rows, then for the rectangle r x c find the smallest possible integer c such that:
 *
 * r * c >= length of message,
 * and c >= r,
 * and c - r <= 1.
 * Our normalized text is 54 characters long, dictating a rectangle with c = 8 and r = 7:
 *
 * "ifmanwas"
 * "meanttos"
 * "tayonthe"
 * "groundgo"
 * "dwouldha"
 * "vegivenu"
 * "sroots  "
 * The coded message is obtained by reading down the columns going left to right.
 *
 * The message above is coded as:
 *
 * "imtgdvsfearwermayoogoanouuiontnnlvtwttddesaohghnsseoau"
 * Output the encoded text in chunks that fill perfect rectangles (r X c), with c chunks of r length, separated by spaces. For phrases that are n characters short of the perfect rectangle, pad each of the last n chunks with a single trailing space.
 *
 * "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "
 * Notice that were we to stack these, we could visually decode the ciphertext back in to the original message:
 *
 * "imtgdvs"
 * "fearwer"
 * "mayoogo"
 * "anouuio"
 * "ntnnlvt"
 * "wttddes"
 * "aohghn "
 * "sseoau "
 * */


fun squareCode(input : String) : String{

    // Step 1: Normalize the text
    val normalized = input.filter { it.isLetterOrDigit() }.lowercase()
    val length = normalized.length
    val c = ceil(sqrt(length.toDouble())).toInt()
    val r = if (c * (c - 1) >= length) c -1 else c // Ensure r * c >= length and c >= r
//56 >= 54 -> 7

    //step 2:
    val rows = mutableListOf<String>()
    for (i in normalized.indices step c){
        rows.add(normalized.substring(i, minOf(i + c, length)).padEnd(c, ' '))
    }

    //step 3:
    val encodeColumns = StringBuilder()
    for (col in 0..<c){
        for (row in rows){
            if(col < row.length){
                encodeColumns.append(row[col])
            }
        }
    }


    return encodeColumns.chunked(r).joinToString(" ")
}

fun main() {
    val input = "If man was meant to stay on the ground, god would have given us roots."
    println(input)

    println(squareCode(input))
}
package november

/**
 * Instructions
 * A circular buffer, cyclic buffer or ring buffer is a data structure
 * that uses a single, fixed-size buffer as if it were connected end-to-end.
 *
 * A circular buffer first starts empty and of some predefined length.
 * For example, this is a 7-element buffer:
 *
 * [ ][ ][ ][ ][ ][ ][ ]
 * Assume that a 1 is written into the middle of the buffer
 * (exact starting location does not matter in a circular buffer):
 *
 * [ ][ ][ ][1][ ][ ][ ]
 * Then assume that two more elements are added — 2 & 3 —
 * which get appended after the 1:
 *
 * [ ][ ][ ][1][2][3][ ]
 * If two elements are then removed from the buffer,
 * the oldest values inside the buffer are removed.
 * The two elements removed, in this case, are 1 & 2,
 * leaving the buffer with just a 3:
 *
 * [ ][ ][ ][ ][ ][3][ ]
 * If the buffer has 7 elements then it is completely full:
 *
 * [5][6][7][8][9][3][4]
 * When the buffer is full an error will be raised,
 * alerting the client that further writes are blocked until a slot becomes free.
 *
 * When the buffer is full, the client can opt to overwrite
 * the oldest data with a forced write. In this case,
 * two more elements — A & B — are added and they overwrite the 3 & 4:
 *
 * [5][6][7][8][9][A][B]
 * 3 & 4 have been replaced by A & B making 5 now the oldest data in the buffer.
 * Finally, if two elements are removed then what would be returned is 5 & 6 yielding the buffer:
 *
 * [ ][ ][7][8][9][A][B]
 * Because there is space available, if the client again uses
 * overwrite to store C & D then the space where 5 & 6 were stored
 * previously will be used not the location of 7 & 8.
 * 7 is still the oldest element and the buffer is once again full.
 *
 * [C][D][7][8][9][A][B]
 * */
class CircularBuffer<T>(private val capacity : Int) {

    private val buffer : Array<Any?> = Array(capacity) { null }
    private var writePointer = 0
    private var readPointer = 0
    private var size = 0

    fun write(element: T){
        if (size == capacity){
            throw IllegalArgumentException("Buffer is full.")
        }

        buffer[writePointer] = element
        writePointer = (writePointer + 1) % capacity
        size++
    }


    fun read() : T{
        if (size == 0){
            throw IllegalArgumentException("Buffer is empty.")
        }
        val element = buffer[readPointer]
        buffer[readPointer] = null
        readPointer = (readPointer + 1) % capacity // (0 + 1) % 7 -> 1
        size--
        return element as T
    }


    fun overwrite(element: T){
        if (size == capacity){
            readPointer = (readPointer + 1) % capacity
        }else{
            size++
        }

        buffer[writePointer] = element
        writePointer = (writePointer + 1) % capacity
    }

    fun displayBuffer() : String {
        return buffer.joinToString(", ", "[","]") {it?.toString() ?: " "}
    }

}

fun main() {
    val buffer = CircularBuffer<String>(7)
    buffer.write("1")
    buffer.write("2")
    buffer.write("3")
    println(buffer.displayBuffer())


    // Read elements from the buffer
    println("Removed: ${buffer.read()}") // 1
    println("Removed: ${buffer.read()}") // 2
    println(buffer.displayBuffer()) // [ , , , , , 3, ]

    // Fill the buffer
    buffer.write("4")
    buffer.write("5")
    buffer.write("6")
    buffer.write("7")
    buffer.write("8")
    buffer.write("9")
    println(buffer.displayBuffer()) // [5, 6, 7, 8, 9, 3, 4]


    // Overwrite elements
    buffer.overwrite("A")
    buffer.overwrite("B")
    println(buffer.displayBuffer()) // [5, 6, 7, 8, 9, A, B]

    // Read elements from the buffer
    println("Removed: ${buffer.read()}") // 1
    println("Removed: ${buffer.read()}") // 2
    println(buffer.displayBuffer()) // [ , , , , , 3, ]

    // Write new elements
    buffer.write("C")
    buffer.write("D")
    println(buffer.displayBuffer()) // [C, D, 7, 8, 9, A, B]

}
package november

fun bubbleSort(arr : IntArray) : IntArray{

    for (i in arr.indices){
        for (j in 0..<arr.size - i - 1){
            if (arr[j] > arr[j +1]){
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

fun main() {
    val numbers = intArrayOf(5,4,6,1,8,2,0)
    println(bubbleSort(numbers).joinToString())


}
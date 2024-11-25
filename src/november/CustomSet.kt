package november

/**
 *
 * Instructions
 * Create a custom set type.
 *
 * Sometimes it is necessary to define a custom data structure of some type,
 * like a set. In this exercise you will define your own set.
 * How it works internally doesn't matter,
 * as long as it behaves like a set of unique elements.
 *
 * */


class CustomSet<T>{

    private val elements = mutableListOf<T>()


    fun add(element : T){
        if (!elements.contains(element)){
            elements.add(element)
        }
    }

    fun remove(element: T) : Boolean{
       return elements.remove(element)
    }

    fun contains(element: T) : Boolean{
        return elements.contains(element)
    }

    fun size() : Int{
        return elements.size
    }


    fun isEmpty() : Boolean{
        return elements.isEmpty()
    }


    fun clear(){
        elements.clear()
    }

    fun union(other: CustomSet<T>) : CustomSet<T>{
        val result = CustomSet<T>()
        result.elements.addAll(this.elements)
        for (element in other.elements){
            result.add(element)
        }
        return result
    }

    fun isSubset(other : CustomSet<T>) : Boolean{
        return elements.all { other.contains(it)} //ensures that every element in the current set exists in the other set.

    }

    fun isDisjoint(other: CustomSet<T>) : Boolean{
        return elements.none { other.contains(it) } //ensures that no element in the current set exists in the other set.
    }


    fun interSection(other: CustomSet<T>) : CustomSet<T>{ // 1, 2, 3   // 3 , 4, 5
        val result = CustomSet<T>()
        for (element in elements){
            if (other.contains(element)){
                result.add(element)
            }
        }
        return  result
    }

    operator fun plus (element: T) : CustomSet<T>{
        val result = CustomSet<T>()
        result.elements.addAll(this.elements)
        result.add(element)
        return result
    }

    operator fun minus (other: CustomSet<T>) : CustomSet<T>{
        val result = CustomSet<T>()
        for (element in elements){
            if (!other.contains(element)){
                result.add(element)
            }
        }
        return result
    }

    override fun toString(): String {
        return "$elements"
    }

    override fun hashCode(): Int {
        return elements.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (elements === other) return true
        if (other !is CustomSet<*>) return false
        return elements.toSet() == other.elements.toSet()
    }


}

fun main() {
    val set1 = CustomSet<Int>()
    set1.add(1)
    set1.add(2)
    set1.add(3)

    val set2 = CustomSet<Int>()
    set2.add(6)
    set2.add(4)
    set2.add(5)

    println("Add $set1")
    println("Add $set2")
    println("Size : ${set1.size()}")
    println("Remove : ${set1.remove(2)}")
    println("Set1 is subset of Set2 : ${set1.isSubset(set2)}")
    println("Set1 is disjoint of Set2 : ${set1.isDisjoint(set2)}")
    println("Intersection: ${set1.interSection(set2)}")
    println("Union: ${set1.union(set2)}")
    println("Set1 isEmpty: ${set1.isEmpty()}")

    val plus = set1 + 5
    println("Set1 Plus 3 is: $plus")

    val minus = set1 - set2
    println("Set1 minus Set2 is : $minus")

}




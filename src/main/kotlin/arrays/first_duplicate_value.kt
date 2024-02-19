package arrays

fun firstDuplicateValue(array: MutableList<Int>): Int {
    array.forEach { k ->
        val pos = Math.abs(k) - 1
        if (array[pos] < 0) {
            return Math.abs(k)
        } else {
            array[pos] = -array[pos]
        }
    }
    return -1
}

fun main(args: Array<String>) {
    println(firstDuplicateValue(mutableListOf(2, 1, 5, 3, 3, 2, 4)))
}
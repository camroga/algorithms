package sort

import java.util.LinkedList
import java.util.Queue


fun threeNumberSort(array: MutableList<Int>, order: List<Int>): List<Int> {
    if (array.isEmpty() || order.isEmpty()) {
        return array
    }
    val currentOrder = if (array.contains(order[0])) order[0] else order[1]
    array.sortByDescending { it == currentOrder }
    val lastIndex = array.filter { it == currentOrder }.lastIndex
    val swapPositions: Queue<Int> = LinkedList()
    var i = lastIndex
    if (i == -1 || currentOrder != order[0]) return array
    while (i < array.size) {
        if (array[i] == order.last()) {
            swapPositions.add(i)
            i++
        } else {
            val pos = swapPositions.poll()
            if (pos != null) {
                val temp = array[pos]
                array[pos] = array[i]
                array[i] = temp
            } else i++
        }
    }
    return array
}

fun main(args: Array<String>) {
//    print(threeNumberSort(mutableListOf(0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 1, 2), listOf(1, 2, 0)))
//    print(threeNumberSort(mutableListOf(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6), listOf(4, 5, 6)))
    print(threeNumberSort(mutableListOf(9, 9, 9, 7, 9, 7, 9, 9, 7, 9), listOf(11, 7, 9)))
}
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
    var n = 0
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
        n++
        println("$n")
    }
    return array
}

fun threeNumberSort2(array: MutableList<Int>, order: List<Int>): List<Int> {
    if (array.isEmpty() || order.isEmpty()) {
        return array
    }
    val lowPriorityQueue: Queue<Int> = LinkedList()
    val highPriorityQueue: Queue<Int> = LinkedList()
    var i = 0
    var n = 0
    while (i < array.size) {
        when (array[i]) {
            order[2] -> {
                highPriorityQueue.add(i)
                i++
            }

            order[1] -> {
                val pos = highPriorityQueue.poll()
                if (pos != null) {
                    swapPositions(array, pos, i)
                    lowPriorityQueue.add(pos)
                } else {
                    lowPriorityQueue.add(i)
                    i++
                }
            }

            order[0] -> {
                val pos = lowPriorityQueue.poll()
                if (pos != null) {
                    swapPositions(array, pos, i)
                } else i++
            }
        }
        n++
        println("$n")
    }
    return array
}

fun swapPositions(array: MutableList<Int>, pos1: Int, pos2: Int) {
    val temp = array[pos1]
    array[pos1] = array[pos2]
    array[pos2] = temp
}

fun main() {
    //2 0
    //1
    print(threeNumberSort(mutableListOf(0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 1, 2), listOf(1, 2, 0)))
//    print(threeNumberSort2(mutableListOf(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6), listOf(4, 5, 6)))
//    print(threeNumberSort2(mutableListOf(9, 9, 9, 7, 9, 7, 9, 9, 7, 9), listOf(11, 7, 9)))
}
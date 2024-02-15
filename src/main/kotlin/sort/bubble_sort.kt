package sort

fun bubbleSort(array: MutableList<Int>): List<Int> {
    println(array)
    (0 until array.size).forEach { i ->
        (i until array.size).forEach { j ->
            if (array[i] > array[j]) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }
    return array
}

fun main(args: Array<String>) {
    print(bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
}

package sort

fun main(args: Array<String>) {
    println(insertionSort(arrayListOf(8, 5, 2, 9, 5, 6, 3)))
}

fun insertionSort(array: MutableList<Int>): List<Int> {
    (1 until array.size).forEach { i ->
        (i - 1 downTo 0).forEach lit@{ j ->
            if (array[j + 1] >= array[j]) {
                return@lit
            }
            val temp = array[j + 1]
            array[j + 1] = array[j]
            array[j] = temp
        }
    }
    return array
}
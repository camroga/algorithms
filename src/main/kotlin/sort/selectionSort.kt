package sort

fun main(args: Array<String>) {
    println(selectionSort(arrayListOf(8, 5, 2, 9, 5, 6, 3)))
}

fun selectionSort(array: MutableList<Int>): List<Int> {
    (0 until array.size).forEach { i ->
        val index = array.subList(i, array.size).withIndex().minBy { (_, ele) -> ele }.index
        val temp = array[i]
        array[i] = array[index + i]
        array[index+ i] = temp
    }
    return array
}
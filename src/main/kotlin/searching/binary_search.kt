package searching

fun binarySearch(array: List<Int>, target: Int): Int {
    val index = array.binarySearch(target)
    return if (index < 0) -1 else index
}

fun binarySearch2(array: List<Int>, target: Int): Int {
    var start = 0
    var end = array.size
    while (start <= end) {
        val index: Int = (end + start) / 2
        if (target > array[index]) {
            start = index + 1
        } else if (target < array[index]) {
            end = index - 1
        } else {
            return index
        }
    }
    return -1
}

fun main(args: Array<String>) {
    println(binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 72))
    println(binarySearch2(listOf(1, 5, 23, 111), 5))
}

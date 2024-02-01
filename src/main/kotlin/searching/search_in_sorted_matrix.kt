package searching

fun searchInSortedMatrix2(matrix: List<List<Int>>, target: Int): Pair<Int, Int> {
    var row = 0
    var col = matrix.first().size - 1
    while (row < matrix.size && col > -1) {
        if (matrix[row][col] > target) {
            col--
        } else if (matrix[row][col] < target) {
            row++
        } else return Pair(row, col)
    }
    return Pair(-1, -1)
}

fun searchInSortedMatrix(matrix: List<List<Int>>, target: Int): Pair<Int, Int> {
    val fr = matrix.indices.map { i ->
        matrix[i][0]
    }.toList() // O(n)
    val rb = binarySearchBoundary(fr, target) // row boundary O(log n)
    if (rb == -1) return Pair(-1, -1) // O(1)
    (0..rb).forEach { i ->  // O(n*log m)
        val index = matrix[i].binarySearch(target) // O(log m)
        if (index > -1) return Pair(i, index)
    }
    return Pair(-1, -1)
}

fun binarySearchBoundary(array: List<Int>, target: Int): Int {
    var start = 0
    var end = array.size
    while (start < end) {
        val index: Int = (end + start) / 2
        if (target > array[index]) {
            start = index + 1
        } else if (target < array[index]) {
            end = index - 1
        } else {
            return index
        }
    }
    return end
}

fun main(args: Array<String>) {
    val items = listOf(
        listOf(1, 4, 7, 12, 15, 1000),
        listOf(2, 5, 19, 31, 32, 1001),
        listOf(3, 8, 24, 33, 35, 1002),
        listOf(40, 41, 42, 44, 45, 1003),
        listOf(99, 100, 103, 106, 128, 1004)
    )
    println(searchInSortedMatrix(items, 44))
    println(searchInSortedMatrix2(items, 44))
}
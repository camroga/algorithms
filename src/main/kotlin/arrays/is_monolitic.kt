package arrays


fun isMonotonic(array: List<Int>): Boolean {
    if(array.size < 2) return true
    var isMBTNumbs: Boolean? = if (array[1] > array[0]) true else if (array[1] < array[0]) false else null

    (1 until array.size - 1).forEach { i ->
        if (isMBTNumbs == null) {
            if (array[i + 1] >= array[i]) isMBTNumbs = true
            if (array[i + 1] <= array[i]) isMBTNumbs = false
        } else {
            if (!isMBTNumbs!! && array[i + 1] > array[i]) {
                return false
            }
            if (isMBTNumbs!! && array[i + 1] < array[i]) {
                return false
            }
        }
    }
    return true
}

fun main(args: Array<String>) {
    println(isMonotonic(listOf(-1, -5, -10, -100, -1100, -1101, -1102, -9001)))
}
package arrays

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    if (array.size < sequence.size) {
        return false
    }
    var i = 0
    var current = sequence.first()
    array.forEach { elem ->
        if (elem == current) {
            i++
            if (i == sequence.size) {
                return true
            }
            current = sequence[i]
        }
    }
    return i >= sequence.size
}

fun main(args: Array<String>) {
    print(isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10)))
}

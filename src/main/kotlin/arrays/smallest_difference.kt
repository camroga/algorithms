package arrays

fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    var i = 0
    var j = 0
    var current = -1
    var sol = mutableListOf<Int>()
    arrayOne.sort()
    arrayTwo.sort()
    do {
        val distance = kotlin.math.abs(arrayOne[i] - arrayTwo[j])

        if (current == -1 || current > distance) {
            current = distance
            sol = mutableListOf(arrayOne[i], arrayTwo[j])
        }

        if (arrayOne[i] < arrayTwo[j]) {
            i++
        } else {
            j++
        }
    } while (i < arrayOne.size && j < arrayTwo.size)
    return sol
}

fun main(args: Array<String>) {
    print(smallestDifference(mutableListOf(-1, 5, 10, 20, 28, 3), mutableListOf(26, 134, 135, 15, 17)))
}

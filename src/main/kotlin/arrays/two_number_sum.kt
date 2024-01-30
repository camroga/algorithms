package arrays

fun main(args: Array<String>) {
    print(twoNumberSum(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10))
}

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val nums = hashSetOf<Int>()
    (0 until array.size).forEach { index ->
        val otherNum = targetSum - array[index]
        if (nums.contains(otherNum)) {
            return listOf(otherNum, array[index])
        }
        nums.add(array[index])
    }
    return listOf()
}
package arrays

import kotlin.math.max

fun missingNumbers2(nums: MutableList<Int>): List<Int> {
    var n = 2
    var prev = 0
    val missingNums = mutableListOf<Int>()
    nums.sort()
    nums.forEach { num ->
        if (n == 0) return missingNums
        prev += 1
        while (num != prev) {
            missingNums.add(prev)
            n -= 1
            prev += 1
        }
    }
    if (nums.isEmpty()) {
        missingNums.add(1)
        missingNums.add(2)
    } else if (n > 0) {
        val newVal = max(nums.lastOrNull() ?: 0, missingNums.lastOrNull() ?: 0) + 1
        missingNums.add(newVal)
        if (n == 2) {
            missingNums.add(newVal + 1)
        }
    }
    return missingNums
}

fun missingNumbers(nums: MutableList<Int>): List<Int> {
    val missNumSize = nums.size + 2
    val result = MutableList(missNumSize) { it.plus(1) }
    result.removeAll(nums)
    return result
}

fun main(args: Array<String>) {
    println(missingNumbers(mutableListOf(3)))
}
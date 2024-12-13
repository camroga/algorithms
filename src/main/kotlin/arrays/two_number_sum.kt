package arrays

fun main() {
    print(twoSum(intArrayOf(3, 2, 4), 6).toList().toString())
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

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsSaved = mutableMapOf<Int, Int>()
    nums.indices.forEach { index ->
        val otherNum = target - nums[index]
        if (numsSaved.contains(otherNum)) {
            return intArrayOf(numsSaved[otherNum]!!, index)
        }
        numsSaved[nums[index]] = index
    }
    return intArrayOf()
}
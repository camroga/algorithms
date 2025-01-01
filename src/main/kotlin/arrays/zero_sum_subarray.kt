package arrays

fun zeroSumSubarray(nums: List<Int>): Boolean {
    if(nums.isEmpty()) return false
    // -5 -5 1 2 3 -2
    return zeroSumSubarray(nums, 0, nums.size-1)
}

fun zeroSumSubarray(nums: List<Int>, i: Int, j: Int): Boolean {
    println("zeroSumSubarray")
    if (i > j) return false
    if(nums.slice(i .. j).sum() == 0) return true
    if(zeroSumSubarray(nums, i+1, j)) return true
    if(zeroSumSubarray(nums, i, j-1)) return true
    return false
}

fun main(args: Array<String>) {
    val input = listOf(1, 2, 3)
    val expected = false
    val output = zeroSumSubarray(input)
    assert(expected == output)
}
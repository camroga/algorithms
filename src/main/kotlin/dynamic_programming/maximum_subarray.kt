package dynamic_programming

fun maxSubArray(nums: IntArray): Int {
    var currentSum = 0
    var maxSum = nums[0]  // Initialize to the first element since array may contain all negatives

    for (num in nums) {
        // Update the current sum: Either extend the current subarray or start a new one
        currentSum = maxOf(num, currentSum + num)

        // Update the maximum sum found so far
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}

fun main(args: Array<String>) {
    val currentMillis = System.currentTimeMillis()
    println(
        maxSubArray(
            intArrayOf(-64, 100, 1001, -156, -999, 1000, 103)
        )
    )
    println("total time maxSubArrayShort: " + (System.currentTimeMillis() - currentMillis))
}

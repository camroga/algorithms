package hash_table

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    // map to save elements with the position
    val visited = mutableMapOf<Int, Int>()
    // loop
    nums.forEachIndexed { i, num ->
        // check visited contain num
        visited[num]?.apply {
            // return true if i j <= k
            if (i != this && Math.abs(this - i) <= k) return true
        }
        visited[num] = i
    }
    // end loop
    return false
}

fun main(args: Array<String>) {
    println(containsNearbyDuplicate(nums = intArrayOf(1, 2, 3, 1), k = 2))
}
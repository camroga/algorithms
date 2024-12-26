package searching

fun binarySearch(array: List<Int>, target: Int): Int {
    val index = array.binarySearch(target)
    return if (index < 0) -1 else index
}

fun binarySearch2(array: List<Int>, target: Int): Int {
    var start = 0
    var end = array.size
    while (start <= end) {
        val index: Int = (end + start) / 2
        if (target > array[index]) {
            start = index + 1
        } else if (target < array[index]) {
            end = index - 1
        } else {
            return index
        }
    }
    return -1
}

fun search(nums: IntArray, target: Int): Int {
    // Binary Search Algorithm
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        // Calculate the middle index
        val mid = start + (end - start) / 2

        when {
            target < nums[mid] -> end = mid - 1   // Search in the left half
            target > nums[mid] -> start = mid + 1 // Search in the right half
            else -> return mid                   // Target found
        }
    }
    return -1 // Target not found
}

fun main() {
    println(binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 72))
    println(binarySearch2(listOf(1, 5, 23, 111), 5))
}

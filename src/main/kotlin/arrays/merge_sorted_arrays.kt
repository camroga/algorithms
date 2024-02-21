package arrays

fun main(args: Array<String>) {
    val mergeSortedArray = MergeSortedArray()
    val nums1 = intArrayOf(-1, 0, 0, 3, 3, 3, 0, 0, 0)
    val nums2 = intArrayOf(1, 2, 2)
    mergeSortedArray.merge(nums1 = nums1, 6, nums2 = nums2, 3)
    println(nums1.toList().toString())
}

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var count = 0
        nums1.filter { e -> e == 0 }.forEach { e ->
            if (count < nums2.size) {
                val index = nums1.indexOf(e)
                nums1[index] = nums2[count]
                count++
            }
        }
        nums1.sort()
    }
}
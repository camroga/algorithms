package arrays

fun threeSum(array: IntArray): List<List<Int>> {
    // array is empty
    if (array.isEmpty() || array.size < 3) return listOf()
    // avoid the repetitive combinations
    val result = mutableSetOf<List<Int>>()
    // sort array
    array.sort()
    // get pair
    array.indices.forEach { i ->
        (i + 1 until array.size).forEach { j ->
            // x + y + z = 0 => z = - (x + y)
            val comp = (array[i] + array[j]) * -1
            // to avoid double counting array[i] < array[j] < array[k]
            // [-1,0,1,2,-1,-4]
            // -1 0  1 correct
            //  0 1 -1 repeated combination
            if (array[i] <= array[j] && array[j] <= comp) {
                // use binary search to find complement
                val k = array.binarySearch(comp)
                // different key
                if (k > -1 && k != i && k != j) {
                    result.add(listOf(array[i], array[j], array[k]))
                }
            }
        }
    }
    return result.toList()
}


fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

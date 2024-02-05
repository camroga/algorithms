fun main(args: Array<String>) {
    val merge_sorted_array = merge_sorted_array()
//    merge_sorted_array.merge(intArrayOf(-1,0,0,3,3,3,0,0,0), 6, intArrayOf(1,2,2), 3)
//    println(removeDuplicatesTwice2(intArrayOf(1,1,1,1)))
//    print(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
//    print(isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10)))
//    print(sortedSquaredArray(listOf(-2, -1)))
//    print(moveElementToEnd(mutableListOf(), 2))
//    print(transposeMatrixOptimized(mutableListOf(mutableListOf(1, 2), mutableListOf(3, 4), mutableListOf(5, 6))))
//    print(tournamentWinner(mutableListOf(mutableListOf("HTML", "C#"), mutableListOf("C#", "Python"), mutableListOf("Python", "HTML")), listOf(0, 0, 1)))

//    print(isPalindrome("abcdcba"))
//    print(caesarCipherEncryptor("abc", 52))
//    print(commonCharacters(mutableListOf("abc", "bcd", "cbaccd")))
//    print(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"))
//    print(generateDocument("abcabc", "aabbccc"))
//    print(firstNonRepeatingCharacter("abcdaf"))
//    print(semordnilap(listOf("aaa", "bbbb")))
//    print(binarySearch(listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 111))
//    print(binarySearch2(listOf(1, 5, 23, 111), 5))
//    print(findThreeLargestNumbers2(listOf(55, 7, 8, 3, 43, 11)))
//    print(getNthFib(6))
//    print(getNthFib2(3))
//    print(productSum(listOf(1, 2, listOf(3), 4, 5)))
//    print(productSum(listOf(5, 2, listOf(7, -1), 3, listOf(6, listOf(-13, 8), 4))))
    print(bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
}

fun rotate(nums: IntArray, k: Int): Unit {

}

fun majorityElement(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    return nums.groupBy { it }.maxBy { it.value.size }?.key ?: 0
}


class merge_sorted_array {
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

fun removeElement(nums: IntArray, `val`: Int): Int {
    var lp = nums.lastIndex
    var c = 0
    nums.filter { e -> e == `val` }.forEach { e ->
        if (e == `val`) {
            val index = nums.indexOf(e)
            val temp = nums[index]
            nums[index] = nums[lp]
            nums[lp] = temp
            lp--
            c++
        }
    }
    return nums.size - c
}

// [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] nr=[ 0 ]
// [0, 0, 1, 4, 1, 1, 2, 2, 3, 3] nr=[ 0 ]
fun removeDuplicates(nums: IntArray): Int {
    var k = 0
    var t = -102
    nums.forEachIndexed { i, e ->
        if (t != e) {
            t = e
        } else {
            k++
            nums[i] = 101
        }
    }
    nums.sort()
    return nums.size - k
}

// 1,1,1,2,2,3
fun removeDuplicatesTwice(nums: IntArray): Int {
    var k = 0
    val t = mutableMapOf<Int, Int>()
    var i = 0
    var lastIndex = nums.lastIndex
    while (i < nums.size - k) {
        if (t[nums[i]] == null || t[nums[i]]!! < 2) {
            t[nums[i]] = t[nums[i]]?.plus(1) ?: 1
            i++
        } else {
            k++
            val temp = nums[i]
            nums[i] = nums[lastIndex]
            nums[lastIndex] = temp
            lastIndex -= 1
        }
    }
    nums.sort(0, nums.size - k)
    return nums.size - k
}


fun removeDuplicatesTwice2(nums: IntArray): Int {
    var k = 0
    var t: Pair<Int, Int>? = null
    val indexs = mutableListOf<Int>()
    var i = 0
    while (i < nums.size) {
        if (t == null || t.first != nums[i]) {
            t = Pair(nums[i], 1)
        } else if (t.second <= 1) {
            t = Pair(t.first, t.second + 1)
        } else {
            indexs.add(nums[i])
        }
        i++
    }
    i = indexs.size - 1
    var lastIndex = nums.lastIndex
    while (i >= 0) {
        val temp = nums[i]
        nums[i] = nums[lastIndex]
        nums[lastIndex] = temp
        lastIndex -= 1
    }

    print(nums.toList())
    return nums.size - indexs.size
}

fun IntArray.swap() {
    this.toList()
}

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    if (array.size < sequence.size) {
        return false
    }
    var i = 0
    var current = sequence.first()
    array.forEach { elem ->
        if (elem == current) {
            i++
            if (i == sequence.size) {
                return true
            }
            current = sequence[i]
        }
    }
    return i >= sequence.size
}

fun sortedSquaredArray(array: List<Int>): List<Int> {
    return array.map { element -> element * element }.sorted()
}

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    array.sortByDescending { it != toMove }
    return array
}



fun transposeMatrixOptimized(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    return (0 until matrix[0].size).map { column ->
        (0 until matrix.size).map { row ->
            matrix[row][column]
        }.toMutableList()
    }.toMutableList()
}

fun twoNumberSumHigh(array: MutableList<Int>, targetSum: Int): List<Int> {
    array.sort()

    var i = 0
    var j = array.lastIndex

    while (i != j) {
        if (array[i] > targetSum) {
            i++
        }
        if (array[i] + array[j] > targetSum) {
            j--
        }
        if (array[i] + array[j] < targetSum) {
            i++
            j = array.lastIndex
        }
        if (array[i] + array[j] == targetSum) {
            return listOf(array[i], array[j])
        }
    }

    return listOf()
}

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val points = hashMapOf<String, Int>()
    competitions.forEachIndexed { i, e ->
        val key = if (results[i] == 1) {
            e[0]
        } else {
            e[1]
        }
        points[key] = (points[key] ?: 0) + 3

    }
    return points.maxBy { it.value }.key
}

fun isPalindrome(string: String): Boolean {
    val length = string.length
    return (0 until length / 2).all { index ->
        string[index] == string[length - index - 1]
    }
}


fun caesarCipherEncryptor(string: String, key: Int): String {
    // Write your code here.
    val zPos = 'z'.code
    val aPos = 'a'.code
    var sol: String = ""
    string.forEach { c ->
        sol += if (c.isLetter()) {
            val codePlusKey = c.code + key
            if (codePlusKey > zPos) {
                var newCode = aPos + codePlusKey - zPos - 1
                while (newCode > zPos) {
                    newCode = aPos + newCode - zPos - 1
                }
                Char(newCode)
            } else {
                Char(codePlusKey)
            }
        } else {
            c
        }
    }
    return sol
}

fun commonCharacters(strings: MutableList<String>): List<String> {
    val common = mutableMapOf<Char, Int>()
    strings.forEachIndexed { i, item ->
        item.forEach { l ->
            if (common[l] == null || common[l] == i) {
                common[l] = (common[l] ?: 0) + 1
            }
        }
    }
    return common.filter { item ->
        item.value == strings.size
    }.map { v -> v.key.toString() }
}

fun runLengthEncoding(string: String): String {
    var currentChar: Char? = null
    var currentValue = 0
    var encodedString = ""
    string.forEach { char ->
        if (currentChar == null) {
            currentChar = char
            currentValue = 1
        } else if (currentChar != char || currentValue == 9) {
            encodedString += "$currentValue$currentChar"
            currentChar = char
            currentValue = 1
        } else {
            currentValue += 1
        }
    }
    encodedString += "$currentValue$currentChar"
    return encodedString
}

fun generateDocument(characters: String, document: String): Boolean {
    if (document.isNullOrEmpty()) {
        return true
    }
    // sort strings to compare
    val documentSorted = document.toCharArray()
    val charactersSorted = characters.toCharArray()
    documentSorted.sort()
    charactersSorted.sort()
    var i = 0
    var j = 0
    do {
        if (j == documentSorted.size) {
            return true
        }
        if (charactersSorted[i] == documentSorted[i]) {
            j++
        }
        i += 1
    } while (i < charactersSorted.size)
    return j == documentSorted.size
}

fun firstNonRepeatingCharacter(string: String): Int {
    val countLetters = mutableMapOf<Char, Int>()
    string.forEach { char ->
        countLetters[char] = (countLetters[char] ?: 0) + 1
    }
    string.forEachIndexed { index, char ->
        if (countLetters[char] == 1) {
            return index
        }
    }
    return -1
}

fun semordnilap(words: List<String>): List<List<String>> {
    val pairs = mutableListOf<List<String>>()
    // create a map to save semordnilap O(n) time executio
    val semordnilaps = hashMapOf<String, Int>()
    words.forEach { word ->
        semordnilaps[word] = (semordnilaps[word] ?: 0) + 1
    }
    // loop to review if the element exists in the map O(n + m) n all words are different m reversed
    semordnilaps.forEach { (key, value) ->
        if (value > 0) {
            val keyReversed = key.reversed()
            semordnilaps[key] = semordnilaps[key]!! - 1
            if (semordnilaps.containsKey(keyReversed) && semordnilaps[keyReversed]!! > 0) {
                semordnilaps[keyReversed] = semordnilaps[keyReversed]!! - 1
                pairs.add(listOf(key, keyReversed))
            }
        }
    }
    return pairs
}

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

fun findThreeLargestNumbers(array: List<Int>): List<Int> {
    val threeLargest = mutableListOf<Int>()
    array.forEach { num ->
        if (threeLargest.size < 3) {
            threeLargest.add(num)
        } else if (num > threeLargest[0]) {
            threeLargest[0] = num
        }
        threeLargest.sort()
    }
    return threeLargest
}

fun findThreeLargestNumbers2(array: List<Int>): List<Int> {
    var min: Int? = null
    var mid: Int? = null
    var max: Int? = null
    array.forEach { num ->
        if (max == null || num >= max!!) {
            min = mid
            mid = max
            max = num
        } else if (mid == null || num >= mid!!) {
            min = mid
            mid = num
        } else if (min == null || num > min!!) {
            min = num
        }
    }
    return listOf(min!!, mid!!, max!!)
}

// 0 1 1 2 3 5
fun getNthFib(n: Int): Int {
    if (n == 1) return 0
    if (n == 2) return 1
    return getNthFib(n - 1) + getNthFib(n - 2)
}

fun getNthFib2(n: Int): Int {
    if (n == 1) return 0
    var prev0 = 0
    var fib = 1
    for (i in 2 until n) {
        val temp = fib
        fib += prev0
        prev0 = temp
    }
    return fib
}

fun productSum(array: List<*>): Int {
    return specialProductSum(array, 1)
}

//1 2 (3) 4 5
fun specialProductSum(array: List<*>, level: Int): Int {
    return array.map {
        val total: Int = if (it is List<*>) {
            specialProductSum(array = it, level = level + 1)
        } else {
            it as Int
        }
        total
    }.sum() * level
}

fun specialProductSum2(array: List<*>, level: Int): Int {
    return array.sumOf {
        if (it is List<*>) {
            specialProductSum(it, level + 1)
        } else {
            it as Int
        }
    } * level
}

fun bubbleSort(array: MutableList<Int>): List<Int> {
    println(array)
    (0 until array.size).forEach { i ->
        (i until array.size).forEach { j ->
            if(array[i] > array[j]) {
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }
    return array
}
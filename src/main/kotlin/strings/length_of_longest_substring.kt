package strings

fun lengthOfLongestSubstringOld(s: String): Int {
    val nl = mutableMapOf<Char, Int>()
    var count = 0
    var mc = 0
    var i = 0
    var j = 0
    while (j < s.length) {
        val c = s[j]
        while (nl.getOrDefault(c, 0) > 0) {
            if (mc < count)
                mc = count
            nl[s[i]] = nl.getOrDefault(s[i], 0) - 1
            i++
            count--
        }
        nl[c] = nl.getOrDefault(c, 0) + 1
        count++
        j++
    }
    return if (mc < count) count else mc
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    val index = IntArray(256) { -1 }
    var start = 0
    var longest = 0
    // iterate s
    s.indices.forEach { i ->
        val charCode = s[i].code
        // if the character has been seen and is within the current window, move the start
        if (index[charCode] >= start) {
            // move start
            start = index[charCode] + 1
        }
        // update the last seen index of the character
        index[charCode] = i
        // calculate the current length and update the max length
        longest = maxOf(longest, i - start + 1)
    }
    return longest
}

fun main() {
    println(lengthOfLongestSubstring(" "))
}
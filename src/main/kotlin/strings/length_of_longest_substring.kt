package strings

fun lengthOfLongestSubstring(s: String): Int {
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

fun main() {
    println(lengthOfLongestSubstring("bbbbb"))
}
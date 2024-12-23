fun binarySearch(a: IntArray, key: Int): Int {
    var lo = 0
    var hi = a.size - 1
    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2
        if (key < a[mid]) hi = mid - 1
        else if (key > a[mid]) lo = mid + 1
        else return mid
    }
    return -1
}

fun wordPattern(pattern: String, s: String): Boolean {
    val words: MutableMap<Char, String> = mutableMapOf()
    val keys: MutableMap<String, Char> = mutableMapOf()
    var i = 0
    val wordsInS = s.split(" ")
    if (wordsInS.size != pattern.length) return false
    wordsInS.forEach { word ->
        if (words[pattern[i]] == null && keys[word] == null) {
            words[pattern[i]] = word
            keys[word] = pattern[i]
        }
        if (keys[word] != pattern[i] || words[pattern[i]] != word) return false
        i++
    }
    return true
}

package strings

fun isAnagram2(s: String, t: String): Boolean {
    return s.toCharArray().sorted() == t.toCharArray().sorted()
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val count = IntArray(26)

    for (i in s.indices) {
        count[s[i] - 'a']++   // Increment count for s
        count[t[i] - 'a']--   // Decrement count for t
    }

    for (c in count) {
        if (c != 0) return false // Check if all counts are zero
    }
    return true
}

fun main(args: Array<String>) {
    isAnagram("anagram", "nagaram")
}
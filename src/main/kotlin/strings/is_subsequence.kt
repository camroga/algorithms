package strings

fun isSubsequence(s: String, t: String): Boolean {
    val S = s.length
    val T = t.length

    if (S > T) return false
    if (S == 0) return true

    var i = 0
    var j = 0
    while (i < S && j < T) {
        if (s[i] == t[j]) {
            i++
        }
        j++
    }
    return i == S
}

fun main(args: Array<String>) {
    println(isSubsequence("abc", "ahbgdc"))
}
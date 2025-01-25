package strings

fun strStr(haystack: String, needle: String): Int {
    val bm = BoyerMoore(needle)
    return bm.search(haystack)
}

fun main(args: Array<String>) {
    val bm = BoyerMoore("leeto")
    println(bm.search("leetcode"))
}
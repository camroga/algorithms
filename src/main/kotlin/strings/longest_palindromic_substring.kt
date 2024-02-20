package strings

fun longestPalindromicSubstring(string: String): String {
    var lps = ""
    string.forEachIndexed { i, v ->
        val op = getLongestPalindrome(string, i, i)
        val ep = getLongestPalindrome(string, i-1, i)
        val current = if (op.length > ep.length) op else ep
        if (current.length > lps.length) {
            lps = current
        }
    }
    return lps
}

fun getLongestPalindrome(string: String, start: Int, end: Int): String {
    var exp = 0
    var cur: String = string[end].toString()
    while (start - exp > -1 && end + exp < string.length) {
        if (string[start - exp] == string[end + exp]) {
            cur = string.substring(start - exp, end + exp + 1)
            exp += 1
        } else {
            return cur
        }
    }
    return cur
}

fun getOddPalindrome(string: String, center: Int): String {
    var exp = 1
    var cur: String = string[center].toString()
    while (center - exp > -1 && center + exp < string.length) {
        if (string[center - exp] == string[center + exp]) {
            cur = string.substring(center - exp, center + exp + 1)
            exp += 1
        } else {
            return cur
        }
    }
    return cur
}

fun getEvenPalindrome(string: String, center: Int): String {
    var exp = 1
    var cur: String = string[center].toString()
    while (center - exp > -1 && center + exp - 1 < string.length) {
        if (string[center - exp] == string[center + exp - 1]) {
            cur = string.substring(center - exp, center + exp)
            exp += 1
        } else {
            return cur
        }
    }
    return cur
}

fun main(args: Array<String>) {
    print(longestPalindromicSubstring("it's highnoon"))
}
package strings

fun isPalindrome(string: String): Boolean {
    val length = string.length
    return (0 until length / 2).all { index ->
        string[index] == string[length - index - 1]
    }
}

fun isPalindromeWithCapitalCaseAndSpaces(s: String): Boolean {
    var i = 0
    var j = s.length - 1
    while (i < j) {
        if (!s[i].isLetterOrDigit()) {
            i++
            continue
        }
        if (!s[j].isLetterOrDigit()) {
            j--
            continue
        }
        if (s[i].lowercaseChar() != s[j].lowercaseChar()) return false
        i++
        j--
    }
    return true
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindromeWithCapitalCaseAndSpaces("A man, a plan, a canal: Panama"))
}

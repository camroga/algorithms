package strings

fun isPalindrome(string: String): Boolean {
    val length = string.length
    return (0 until length / 2).all { index ->
        string[index] == string[length - index - 1]
    }
}

fun main(args: Array<String>) {
    print(isPalindrome("abcdcba"))
}

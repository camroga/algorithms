package math

fun isPalindromeOld(x: Int): Boolean {
    val xString = x.toString()
    var i = 0
    var j = xString.length - 1

    while (i < j) {
        // Directly compare the characters at positions i and j
        if (xString[i] != xString[j]) return false
        i++
        j--
    }

    return true
}

fun isPalindrome(x: Int): Boolean {
    // negative numbers are not palindrome
    if (x < 0) return false
    // handle the case where the last digit is 0, and the number is not 0 itself
    if (x % 10 == 0 && x != 0) return false

    var reversedHalf = 0
    var number = x

    // reverse the second half of the number
    while (number > reversedHalf) {
        reversedHalf = reversedHalf * 10 + number % 10
        number /= 10
    }

    // if the number is the same as the reversed half or
    // the number equals the reversed half divided by 10 (in case of odd length numbers),
    // then it is a palindrome.
    return number == reversedHalf || number == reversedHalf / 10
}



fun main(args: Array<String>) {
    println(isPalindrome(-121))
    println(isPalindrome(12133121))
}
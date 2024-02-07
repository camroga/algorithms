package strings

fun reverseWordsInString(string: String): String {
    var reversedString = ""
    var wordContainer = ""

    string.forEach { ele ->
        if (ele == ' ') {
            reversedString = ele + wordContainer + reversedString
            wordContainer = ""
        } else {
            wordContainer += ele
        }
    }
    reversedString = wordContainer + reversedString
    return reversedString
}

fun main(args: Array<String>) {
    println(reverseWordsInString("AlgoExpert is the best!"))
}
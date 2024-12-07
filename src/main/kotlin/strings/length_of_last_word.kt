package strings

fun lengthOfLastWord(s: String): Int {
    // Trim the string and split by spaces to avoid leading/trailing spaces

//    val trimmed = s.trim()
//    if (trimmed.isEmpty()) return 0
//    return trimmed.split(" ").last().length

//    val exp = Regex("\\s+")
//    val result = s.split(exp)
//    return result.last().length

    var i = s.length - 1
    var c = 0
    var space = false
    while (i > -1) {
        if (s[i] == ' ' && space) break
        if (s[i] != ' ') {
            space = true
            c++
        }
        i--
    }

    return c
//    return s.trim().split(" ").last().length
}

fun main(args: Array<String>) {
    print(lengthOfLastWord("   fly me   to   the moon  "))
}
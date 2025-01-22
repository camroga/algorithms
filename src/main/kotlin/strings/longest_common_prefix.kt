package strings

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]

    val maxPrefixLength = strs.minOf { it.length }
    val prefixBuilder = StringBuilder()

    for (i in 0 until maxPrefixLength) {
        val currentChar = strs[0][i]
        if (strs.any { it[i] != currentChar }) {
            break
        }
        prefixBuilder.append(currentChar)
    }

    return prefixBuilder.toString()
}

fun main(args: Array<String>) {
    println(longestCommonPrefix(arrayOf("", "b")))
}
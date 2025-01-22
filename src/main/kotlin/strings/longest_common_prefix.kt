package strings

fun longestCommonPrefixOld(strs: Array<String>): String {
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

fun longestCommonPrefixOpt(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    var prefix = strs[0]
    for (i in 1 until strs.size) {
        while (!strs[i].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return "" // No common prefix
        }
    }
    return prefix
}


fun main(args: Array<String>) {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}
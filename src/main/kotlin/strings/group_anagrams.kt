package strings

fun groupAnagrams(words: List<String>): List<List<String>> {
    val groups = mutableMapOf<String, MutableList<String>>()
    words.forEach { word ->
        val ws = word.toCharArray().sorted()

        if (groups[ws.toString()] == null) {
            groups[ws.toString()] = mutableListOf(word)
        } else groups[ws.toString()]?.add(word)
    }
    return groups.values.map { wv -> wv }.toList()
}

fun main(args: Array<String>) {
    print(groupAnagrams(listOf("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")))
}
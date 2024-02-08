package strings

fun minimumCharactersForWords(words: List<String>): List<Char> {
    val dic = mutableMapOf<Char, List<Char>>()
    // loop for the words
    words.forEach { word -> // O(n)
        // loop each word
        word
            .groupBy { it } // O(n) * O(l)
            .forEach { (key, value) ->
                // save in a dictionary the number of unique characters with the maximum of repetitions required
                dic.merge(key, value) { existing, new ->
                    if (existing.size < new.size) new else existing
                }
            }
    }
    return dic.values.flatten()
}

fun main(args: Array<String>) {
    print(minimumCharactersForWords(listOf("this", "that", "did", "deed", "them!", "a")))
}
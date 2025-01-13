package hash_table

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    // initialize an array to count letters in the magazine
    val letterCounts = IntArray(26) // Array to store counts for 'a' to 'z'
    val offset = 'a'.code // ASCII code of 'a' as the base offset

    // count each letter in the magazine
    magazine.forEach { letter ->
        letterCounts[letter.code - offset]++
    }
    // verify if the ransom note can be constructed
    ransomNote.forEach { letter ->
        // letter is missing
        if(letterCounts[letter.code - offset] == 0) return false
        // reduce the counter in 1
        letterCounts[letter.code - offset]--
    }
    return true
}

fun main(args: Array<String>) {
    println(canConstruct("aa", "aab"))
}
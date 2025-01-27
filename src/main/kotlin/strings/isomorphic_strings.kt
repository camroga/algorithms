package strings

fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val isoMap = mutableMapOf<Char, Char>()
    val reverseMap = mutableMapOf<Char, Char>()
    var i = 0
    while (i < s.length) {
        val sChar = s[i]
        val tChar = t[i]
        if ((isoMap.contains(sChar) && isoMap[sChar] != tChar) ||
            (reverseMap.contains(tChar) && reverseMap[tChar] != sChar)
        ) {
            return false
        }

        isoMap[sChar] = tChar
        reverseMap[tChar] = sChar
        i++
    }
    return true
}

fun main(args: Array<String>) {
    println(isIsomorphic("egg", "add"))
}
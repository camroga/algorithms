package strings

class BoyerMoore(val pat: String) {
    var right: MutableList<Int>
    var M: Int = pat.length
    val R: Int = 256

    init {
        right = MutableList(R) { -1 }
        (0 until M).forEach { j ->
            //overwrite last pos
            right[pat[j].code] = j
        }
    }

    fun search(txt: String): Int {
        val N = txt.length
        var skip: Int
        var i = 0
        while (i <= N - M) {
            skip = 0
            var j = M - 1
            while (j >= 0) {
                if (pat[j].code != txt[i + j].code) {
                    skip = j - right[txt[i + j].code]
                    if (skip < 1) skip = 1
                    break
                }
                j--
            }
            if (skip == 0) return i
            i += skip
        }
        return -1
    }
}

fun main(args: Array<String>) {
    val bm = BoyerMoore("leeto")
    println(bm.search("leetcode"))
}
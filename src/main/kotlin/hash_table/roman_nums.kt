package hash_table

val romanNums = hashMapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun romanToInt(s: String): Int {
    var r = 0
    var pv = 0
    // LX = 60 XIII = 13 IV = 4
    // MCMXCIV = 1994
    var rep = 0
    s.forEach { c ->
        val cv: Int = romanNums.getOrDefault(c, 0)
        if (pv == cv) rep++ else rep = 0
        if (rep > 3) return 0
        if (pv < cv) r += -pv + (cv - pv)
        else r += cv
        pv = cv
    }
    return r
}

fun main(args: Array<String>) {
    println(romanToInt("MCMXCIV"))
}
package binary_search_trees

import kotlin.random.Random

val versions = mutableListOf<Boolean>()
var n = 0

fun firstBadVersion(n: Int): Int {
    var s = 1
    var e = n
    while (s < e) {
        val m = s + (e - s) / 2
        if (isBadVersion(m)) {
            e = m
        } else {
            s = m + 1
        }
    }
    return s
}

fun isBadVersion(m: Int): Boolean {
    if (versions.isEmpty()) {
        generateBadVersions(n)
    }
    return versions[m - 1]
}

fun generateBadVersions(n: Int) {
    // Generate number between 1 and n (inclusive)
    val rn = Random.nextInt(0, n)
    repeat(n) {
        when {
            it < rn -> versions.add(it, false)
            else -> versions.add(it, true)
        }
    }
}

fun main(args: Array<String>) {
    n = Random.nextInt(5, 10)
    println(firstBadVersion(n))
}
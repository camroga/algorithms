package greedy

import kotlin.math.max
import kotlin.math.min

fun tandemBicycle(redShirtSpeeds: MutableList<Int>, blueShirtSpeeds: MutableList<Int>, fastest: Boolean): Int {
    if (fastest) {
        redShirtSpeeds.sortDescending()
    } else {
        redShirtSpeeds.sort()
    }
    blueShirtSpeeds.sort()
    return (0 until redShirtSpeeds.size).sumOf { i ->
        max(blueShirtSpeeds[i], redShirtSpeeds[i])
    }
}
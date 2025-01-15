package stack_queue

import java.util.*

fun bestDigits(number: String, numDigits: Int): String {
    val a = ArrayDeque<Char>()
    val mz = number.length - numDigits
    var rd = 0
    number.forEach { n ->
        while (
            a.isNotEmpty() &&
            a.peekLast().digitToInt() < n.digitToInt() &&
            rd < numDigits
        ) {
            a.pollLast()
            rd++
        }

        if (a.size < mz) a.offer(n) else rd++
    }
    return a.joinToString("")
}

fun main(args: Array<String>) {
    //8682839
    //882839
    println(bestDigits("10000000002", 9))
}
package stack_queue

import java.util.*

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (char in s) {
        when (char) {
            '(', '[', '{' -> stack.push(char) // Push opening brackets to the stack
            ')', ']', '}' -> {
                if (stack.isEmpty()) return false // No matching opening bracket
                val top = stack.pop()
                if (!isMatchingPair(top, char)) return false // Mismatch in pair
            }
        }
    }

    return stack.isEmpty() // All brackets should be matched by the end
}

private fun isMatchingPair(open: Char, close: Char): Boolean {
    return when (open) {
        '(' -> close == ')'
        '[' -> close == ']'
        '{' -> close == '}'
        else -> false
    }
}

fun main(args: Array<String>) {
    println(isValid("([])"))
}
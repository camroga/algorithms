package stack_queue

import java.util.*

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    s.forEach { e ->
        if (e == '(' || e == '[' || e == '{') stack.push(e)
        else {
            if (stack.none()) return false
            val se = stack.pop()
            if (
                se != '(' && e == ')' ||
                se != '[' && e == ']' ||
                se != '{' && e == '}'
            ) return false
        }
    }
    if (stack.isNotEmpty()) return false
    return true
}

fun main(args: Array<String>) {
    println(isValid("([])"))
}
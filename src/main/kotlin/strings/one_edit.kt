package strings

import kotlin.math.abs

fun oneEdit(stringOne: String, stringTwo: String): Boolean {
    val oneLen = stringOne.length
    val twoLen = stringTwo.length

    if (abs(twoLen - oneLen) > 1) return false

    var edits = false

    val mimSize = if (oneLen > twoLen) twoLen else oneLen

    var i = 0
    var j = 0
    var index = 0
    while (index < mimSize) {
        if (stringOne[i] != stringTwo[j]) {
            if (edits) {
                return false
            }
            if (oneLen == twoLen) {
                index += 1
                i += 1
                j += 1
            } else if (oneLen > twoLen) {
                i += 1
            } else {
                j += 1
            }
            edits = true
        } else {
            index += 1
            i += 1
            j += 1
        }
    }
    return true
}

fun main(args: Array<String>) {
    print(oneEdit("a", "b"))
}
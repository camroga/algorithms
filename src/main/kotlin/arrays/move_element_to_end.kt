package arrays

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    array.sortByDescending { it != toMove }
    return array
}

fun main(args: Array<String>) {
    print(moveElementToEnd(mutableListOf(), 2))
}

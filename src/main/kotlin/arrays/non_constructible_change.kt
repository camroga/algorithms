package arrays

fun main(args: Array<String>) {
    print(nonConstructibleChange(mutableListOf(5, 7, 1, 1, 2, 3, 22)))
}

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    var currentChangeCreated = 0 // not available minimum amount of change
    coins.sort()
    coins.forEach { coin ->
        if (coin > currentChangeCreated + 1) {
            return currentChangeCreated + 1
        }
        currentChangeCreated += coin
    }
    return currentChangeCreated + 1
}
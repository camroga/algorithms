package greedy

fun minimumWaitingTime(queries: MutableList<Int>): Int {
    queries.sort()
    var totalTime = 0
    var previousDuration = queries[0]
    (1 until queries.size).forEach { i ->
        totalTime += previousDuration
        previousDuration += queries[i]
    }
    return totalTime
}
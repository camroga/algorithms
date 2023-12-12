package greedy


fun optimalFreelancing(jobs: MutableList<Map<String, Int>>): Int {
    // max deadline
    // loop max dead line - 0
    // get max profit for each day
    // sum
    // return value
    if (jobs.isEmpty()) {
        return 0
    }
    var total = 0
    jobs.sortByDescending { it["deadline"] }
    val deadLineMax = jobs.first()["deadline"] ?: 0

    (deadLineMax downTo 1).forEach { i ->
        val result = jobs
            .map { Pair(it["deadline"], it["payment"]) }
            .filter { (it.first ?: 0) >= i }
            .maxByOrNull { it.second ?: 0 }
        if (result != null) {
            jobs.removeIf { it["deadline"] == result.first && it["payment"] == result.second }
            total += result.second ?: 0
        }
    }
    return total
}

fun main(args: Array<String>) {
    //resultado 13 por que deadline 2 implica que tengo 2 dias el 1 o el 2 por que cada tarea se demora un dia
    val list = mutableListOf<Map<String, Int>>(
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 2)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 3)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 4)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 5)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 6)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 7)
        )
    )

    val list2 = mutableListOf<Map<String, Int>>(
        mutableMapOf(
            Pair("deadline", 1),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 2),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 3),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 4),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 5),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 6),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 7),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 8),
            Pair("payment", 1)
        ),
        mutableMapOf(
            Pair("deadline", 9),
            Pair("payment", 1)
        ),

        mutableMapOf(
            Pair("deadline", 10),
            Pair("payment", 1)
        ),
    )

    println(optimalFreelancing(list2))
}
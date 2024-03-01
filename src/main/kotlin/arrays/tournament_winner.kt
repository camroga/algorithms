package arrays

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val points = hashMapOf<String, Int>()
    competitions.forEachIndexed { i, e ->
        val key = if (results[i] == 1) {
            e[0]
        } else {
            e[1]
        }
        points[key] = (points[key] ?: 0) + 3

    }
    return points.maxBy { it.value }.key
}

fun main(args: Array<String>) {
    print(
        tournamentWinner(
            mutableListOf(
                mutableListOf("HTML", "C#"),
                mutableListOf("C#", "Python"),
                mutableListOf("Python", "HTML")
            ), listOf(0, 0, 1)
        )
    )
}
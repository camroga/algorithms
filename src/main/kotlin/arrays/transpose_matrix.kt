package arrays

fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val sol: MutableList<MutableList<Int>> = mutableListOf()
    for (j in 0 until matrix[0].size) {
        sol.add(j, mutableListOf())
        for (i in 0 until matrix.size) {
            sol[j].add(matrix[i][j])
        }
    }
    return sol
}

fun main(args: Array<String>) {
    print(transposeMatrix(mutableListOf(mutableListOf(1, 2), mutableListOf(3, 4), mutableListOf(5, 6))))
}
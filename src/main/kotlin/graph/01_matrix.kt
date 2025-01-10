package graph
import java.util.*

fun updateMatrixBFS(mat: Array<IntArray>): Array<IntArray> {
    val rows = mat.size
    val cols = mat[0].size
    val result = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }
    val queue = ArrayDeque<Pair<Int, Int>>()

    // initialize the queue with all '0' cells
    // set their in result with distances to 0
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (mat[row][col] == 0) {
                result[row][col] = 0
                queue.push(Pair(row, col))
            }
        }
    }

    // directions for traversing up, down, left, and right
    val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    // perform BFS
    while (queue.isNotEmpty()) {
        // zero distance
        val (currentRow, currentCol) = queue.pop()

        //review in all the directions
        for ((dr, dc) in directions) {
            val newRow = currentRow + dr
            val newCol = currentCol + dc

            // check if position is valid and if a shorter distance can be found
            if (newRow in 0 until rows && newCol in 0 until cols) {
                if (result[newRow][newCol] > result[currentRow][currentCol] + 1) {
                    result[newRow][newCol] = result[currentRow][currentCol] + 1
                    queue.add(Pair(newRow, newCol))
                }
            }
        }
    }

    return result
}

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val rows = mat.size
    val cols = mat[0].size
    val result = Array(rows) { IntArray(cols) { Int.MAX_VALUE - 10000 } } // Prevent overflow

    // First pass: Top-left to bottom-right
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (mat[row][col] == 0) {
                result[row][col] = 0
            } else {
                //right
                if (row > 0) {
                    result[row][col] = minOf(result[row][col], result[row - 1][col] + 1)
                }
                //bottom
                if (col > 0) {
                    result[row][col] = minOf(result[row][col], result[row][col - 1] + 1)
                }
            }
        }
    }

    // Second pass: Bottom-right to top-left
    for (row in rows - 1 downTo 0) {
        for (col in cols - 1 downTo 0) {
            //
            if (row < rows - 1) {
                result[row][col] = minOf(result[row][col], result[row + 1][col] + 1)
            }
            if (col < cols - 1) {
                result[row][col] = minOf(result[row][col], result[row][col + 1] + 1)
            }
        }
    }

    return result
}

fun main(args: Array<String>) {
    //[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]
    val s = updateMatrix(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 0, 1, 1, 1),
            intArrayOf(1, 0, 1, 1, 1)
        )
    )
    val x = updateMatrixBFS(arrayOf(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 1, 1)
    ))
    s.forEach {
        it.forEach { item -> println(item) }
        println("")
    }
    println("---->")
    x.forEach {
        it.forEach { item -> println(item) }
        println("")
    }
}
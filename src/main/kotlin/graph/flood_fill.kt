package graph

import java.util.*

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val originColor = image[sr][sc]
    // Early exit if the starting pixel already has the target color
    if (originColor == color) return image
    val floodFill = ArrayDeque<Pair<Int, Int>>()
    floodFill.push(Pair(sr, sc))
    //loop
    //criteria to stop
    while (floodFill.isNotEmpty()) {
        val pixel = floodFill.pop()
        //change pixel color
        image[pixel.first][pixel.second] = color
        //same color and adjacent
        findAdjacentSameColor(image, pixel.first, pixel.second, originColor, floodFill)
    }
    //return value
    return image
}

fun adjacentSameColor(image: Array<IntArray>, sr: Int, sc: Int, color: Int, adjacents: ArrayDeque<Pair<Int, Int>>) {
    //left
    if (sr - 1 > -1 && image[sr - 1][sc] == color) {
        adjacents.push(Pair(sr - 1, sc))
    }
    //right
    if (sr + 1 < image.size && image[sr + 1][sc] == color) {
        adjacents.push(Pair(sr + 1, sc))
    }
    //top
    if (sc - 1 > -1 && image[sr][sc - 1] == color) {
        adjacents.push(Pair(sr, sc - 1))
    }
    //bottom
    if (sc + 1 < image[0].size && image[sr][sc + 1] == color) {
        adjacents.push(Pair(sr, sc + 1))
    }
}

fun findAdjacentSameColor(image: Array<IntArray>, sr: Int, sc: Int, color: Int, floodFill: ArrayDeque<Pair<Int, Int>>) {
    val directions = arrayOf(
        Pair(0, 1),   // Right
        Pair(0, -1),  // Left
        Pair(1, 0),   // Down
        Pair(-1, 0)   // Up
    )

    for ((dx, dy) in directions) {
        val newRow = sr + dx
        val newCol = sc + dy

        // Check bounds and color match
        if (newRow in image.indices && newCol in image[0].indices && image[newRow][newCol] == color) {
            floodFill.push(Pair(newRow, newCol))
        }
    }
}


fun main(args: Array<String>) {
    println(
        floodFill(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)), 1, 1, 2)
            .contentDeepToString()
    )
}
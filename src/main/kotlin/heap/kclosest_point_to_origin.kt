import java.lang.Math.hypot
import java.util.*

fun kClosestSorted(points: Array<IntArray>, k: Int): Array<IntArray> {
    return points
        .sortedBy { it.euclideanDistance() }
        .take(k).toTypedArray()
}

fun IntArray.euclideanDistance(): Double =
    hypot(this[0].toDouble(), this[1].toDouble())

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val pk = PriorityQueue<IntArray> { a, b ->
        b.squaredDistance() - a.squaredDistance()
    }

    points.forEach {
        pk.add(it)
        if (pk.size > k) {
            pk.poll()
        }
    }

    return pk.take(k).toTypedArray()
}

fun IntArray.squaredDistance(): Int = this[0] * this[0] + this[1] * this[1]

fun main() {
    //[[1,3],[-2,2]], k = 1
//    val sol = kClosest(arrayOf(intArrayOf(1,3), intArrayOf(-2,2)), 1)
    //[[3,3],[5,-1],[-2,4]]
    val sol = kClosest(arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2)
    sol.forEach {
        println(it.toList())
    }
}

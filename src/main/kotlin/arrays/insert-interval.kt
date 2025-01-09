import kotlin.math.max
import kotlin.math.min


fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf(newInterval)

    val result = ArrayList<IntArray>()

    // Binary search for the start and end positions
    val startPos = searchPosition(intervals, newInterval[0], true)
    val endPos = searchPosition(intervals, newInterval[1], false)

    // Add all intervals before the start of the new interval
    result.addAll(intervals.slice(0..(if (startPos.second) startPos.first - 1 else startPos.first)))

    // Merge overlapping intervals
    val start = if (startPos.second) minOf(newInterval[0], intervals[startPos.first][0]) else newInterval[0]
    val end = if (endPos.second) maxOf(newInterval[1], intervals[endPos.first][1]) else newInterval[1]
    result.add(intArrayOf(start, end))

    // Add all intervals after the new interval
    result.addAll(intervals.slice((if (endPos.second) endPos.first + 1 else endPos.first) until intervals.size))

    return result.toTypedArray()
}

fun searchPosition(intervals: Array<IntArray>, ni: Int, isCheckingStart: Boolean): Pair<Int, Boolean> {
    var s = 0
    var e = intervals.size - 1
    // [[1,3],[6,9],[9,10],[11,12],[12,13]], newInterval = [4,_]
    while (s <= e) {
        val mid = s + (e - s) / 2
        if (intervals[mid][0] < ni && intervals[mid][1] < ni) {
            s = mid + 1
        } else if (intervals[mid][0] > ni && intervals[mid][1] > ni) {
            e = mid - 1
        } else if (intervals[mid][0] <= ni && intervals[mid][1] >= ni) {
            return Pair(mid, true)
        }
    }
    val pos = if (isCheckingStart) e else s
    return Pair(pos, false)
}

fun insertBinarySearch(intervals: Array<IntArray>, newInterval: IntArray) =
    intervals.asList().run {
        var l = binarySearchBy(newInterval[0]) { it[1] };
        if (l < 0)
            l = -l - 1
        var r = binarySearchBy(newInterval[1] + 1) { it[0] };
        if (r < 0)
            r = -r - 1
        val min = min(newInterval[0], (getOrNull(l) ?: newInterval)[0])
        val max = max(newInterval[1], (getOrNull(r - 1) ?: newInterval)[1])
        (take(l) + listOf(intArrayOf(min, max)) + drop(r)).toTypedArray()
    }

fun main() {

    /*val sol = insert(
        intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16)
        ), newInterval = intArrayOf(4, 8)
    )*/
    /*val sol = insert(
        intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9),
        ), newInterval = intArrayOf(2, 5)
    )*/
    val sol = insert(
        intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16),
        ), newInterval = intArrayOf(4, 8)
    )
//    val sol = insert(
//        intervals = arrayOf(
//            intArrayOf(0, 3),
//            intArrayOf(6, 8),
//            intArrayOf(9, 12),
//        ), newInterval = intArrayOf(0, 4)
//    )
//    val sol = insert(
//        intervals = arrayOf(
//            intArrayOf(1, 5),
//        ), newInterval = intArrayOf(6, 8)
//    )
    sol.forEach {
        print(it.toList())
    }
}

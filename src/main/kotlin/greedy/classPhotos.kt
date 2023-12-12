package greedy

fun main(args: Array<String>) {
//    "blueShirtHeights": [2, 4, 7, 5, 1]
//    "redShirtHeights": [3, 5, 6, 8, 2]
    print(classPhotos(mutableListOf(2, 4, 7, 5, 1), mutableListOf(3, 5, 6, 8, 2)))
}

fun classPhotos(redShirtHeights: MutableList<Int>, blueShirtHeights: MutableList<Int>): Boolean {
    //Sort red and blue list
    //Check each element of the blue list should be high or lower depending on the first element
    redShirtHeights.sort()
    blueShirtHeights.sort()
    var checkBlueTaller = blueShirtHeights[0] > redShirtHeights[0]
    var result = true
    (0 until blueShirtHeights.size).forEach { i ->
        if(blueShirtHeights[i] == redShirtHeights[i]) {
            result = false
            return@forEach
        }
        if(checkBlueTaller) {
            if(blueShirtHeights[i] < redShirtHeights[i]) {
                result = false
                return@forEach
            }
        } else {
            if(blueShirtHeights[i] > redShirtHeights[i]) {
                result = false
                return@forEach
            }
        }
    }
    return result
}
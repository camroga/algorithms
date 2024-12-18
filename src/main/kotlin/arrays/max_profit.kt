package arrays

fun maxProfit(prices: IntArray): Int {
    // 7 1 5 3 6 4
    if (prices.isEmpty()) return 0 // No prices available
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0
    for (price in prices) {
        // Update the minimum price seen so far
        if (price < minPrice) {
            minPrice = price
        } else {
            // Calculate potential profit and update maxProfit if it's greater
            maxProfit = maxOf(maxProfit, price - minPrice)
        }
    }
    return maxProfit
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices)) // Output: 5
}
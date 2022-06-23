package dynamic_programming.min_coins

import kotlin.jvm.JvmStatic

// A Naive recursive JAVA program to find minimum of coins
// to make a given change V
internal object coin {
    // m is size of coins array (number of different coins)
    private fun minCoins(coins: IntArray, coinsNumber: Int, V: Int): Int {
        // base case
        if (V == 0) return 0

        // Initialize result
        var res = Int.MAX_VALUE

        // Try every coin that has smaller value than V
        for (i in 0 until coinsNumber) {
            if (coins[i] <= V) {
                val sub_res = minCoins(coins, coinsNumber, V - coins[i])

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Int.MAX_VALUE && sub_res + 1 < res) res = sub_res + 1
            }
        }
        return res
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val coins = intArrayOf(9, 6, 5, 1)
        val coinsNumber = coins.size
        val V = 11
        println("Minimum coins required is " + minCoins(coins, coinsNumber, V))
    }
}
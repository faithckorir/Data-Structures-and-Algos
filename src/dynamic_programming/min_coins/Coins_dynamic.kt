package dynamic_programming.min_coins

import kotlin.jvm.JvmStatic
import dynamic_programming.min_coins.Coins_dynamic

// A Dynamic Programming based Java
// program to find minimum of coins
// to make a given change V
internal object Coins_dynamic {
    // m is size of coins array
    // (number of different coins)
    private fun minCoins(coins: IntArray, m: Int, V: Int): Int {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        val table = IntArray(V + 1)

        // Base case (If given value V is 0)
        table[0] = 0

        // Initialize all table values as Infinite
        for (i in 1..V) table[i] = Int.MAX_VALUE

        // Compute minimum coins required for all
        // values from 1 to V
        for (i in 1..V) {
            // Go through all coins smaller than i
            for (j in 0 until m) if (coins[j] <= i) {
                val sub_res = table[i - coins[j]]
                if (sub_res != Int.MAX_VALUE
                    && sub_res + 1 < table[i]
                ) table[i] = sub_res + 1
            }
        }
        return if (table[V] == Int.MAX_VALUE) -1 else table[V]
    }

    // Driver program
    @JvmStatic
    fun main(args: Array<String>) {
        val coins = intArrayOf(9, 6, 5, 1)
        val m = coins.size
        val V = 11
        println(
            "Minimum coins required is "
                    + minCoins(coins, m, V)
        )
    }
}
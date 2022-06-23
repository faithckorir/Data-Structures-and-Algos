package algorithms.greedy

import java.util.*

// Java program to solve fractional Knapsack Problem
// Greedy approach
object FractionalKnapSack {
    // function to get maximum value
    private fun getMaxValue(
        wt: IntArray, `val`: IntArray,
        capacity: Int
    ): Double {
        var capacity = capacity
        val iVal = arrayOfNulls<ItemValue>(wt.size)
        for (i in wt.indices) {
            iVal[i] = ItemValue(wt[i], `val`[i], i)
        }

        // sorting items by value;
        Arrays.sort(iVal) { o1, o2 -> o2!!.cost.compareTo(o1!!.cost) }
        var totalValue = 0.0
        for (i in iVal) {
            val curWt = i!!.wt.toInt()
            val curVal = i.`val`.toInt()
            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt
                totalValue += curVal.toDouble()
            } else {
                // item cant be picked whole
                val fraction = capacity.toDouble() / curWt.toDouble()
                totalValue += curVal * fraction
                capacity = (capacity - curWt * fraction).toInt()
                break
            }
        }
        return totalValue
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val wt = intArrayOf(10, 40, 20, 30)
        val `val` = intArrayOf(60, 40, 100, 120)
        val capacity = 50
        val maxValue = getMaxValue(wt, `val`, capacity)

        // Function call
        println(
            "Maximum value we can obtain = "
                    + maxValue
        )
    }

    // item value class
    internal class ItemValue(wt: Int, `val`: Int, ind: Int) {
        var cost: Double
        var wt: Double
        var `val`: Double
        var ind: Double

        // item value function
        init {
            this.wt = wt.toDouble()
            this.`val` = `val`.toDouble()
            this.ind = ind.toDouble()
            cost = `val`.toDouble() / wt.toDouble()
        }
    }
}
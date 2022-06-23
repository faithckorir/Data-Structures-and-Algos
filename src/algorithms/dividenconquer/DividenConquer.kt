package algorithms.dividenconquer

import algorithms.dividenconquer.DividenConquer
import kotlin.jvm.JvmStatic

// Java code to demonstrate Divide and
// Conquer Algorithm
internal object DividenConquer {
    // Function to find the maximum no.
    // in a given array.
    fun DAC_Max(a: IntArray, index: Int, l: Int): Int {
        val max: Int
        if (index >= l - 2) {
            return if (a[index] > a[index + 1]) a[index] else a[index + 1]
        }

        // Logic to find the Maximum element
        // in the given array.
        max = DAC_Max(a, index + 1, l)
        return if (a[index] > max) a[index] else max
    }

    // Function to find the minimum no.
    // in a given array.
    fun DAC_Min(a: IntArray, index: Int, l: Int): Int {
        val min:Int
        if (index >= l - 2) {
            return if (a[index] < a[index + 1]) {
                a[index]
            } else {
                a[index + 1]
            }
        }

        // Logic to find the Minimum element
        // in the given array.

        min = DAC_Min(a, index + 1, l)
        println("Currently comparing ${a[index]} $min")

        return if (a[index] < min) a[index] else min
    }

    // Driver Code
    @JvmStatic
    fun main(args: Array<String>) {

        // Defining the variables
        val min: Int
        val max: Int

        // Initializing the array
        val a = intArrayOf(12,70, 250, 14 ,50, 80, 140)

        // Recursion - DAC_Max function called
        max = DAC_Max(a, 0, 7)

        // Recursion - DAC_Max function called
        min = DAC_Min(a, 0, 7)
        System.out.printf(
            """
    The minimum number in a given array is : %d
    
    """.trimIndent(), min
        )
        System.out.printf(
            "The maximum number in " +
                    "a given array is : %d", max
        )
    }
}
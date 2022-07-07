package ownpractise.strings

import kotlin.jvm.JvmStatic

// Java program to find missing Number
// using xor
internal object FindMissingNumber {
    // Function to find missing number
    fun getMissingNo(a: IntArray, n: Int): Int {
        var x1 = a[0]
        var x2 = 1

        /* For xor of all the elements
		in array */
        for (i in 1 until n) {
            x1 = x1 xor a[i]
        }

        /* For xor of all the elements
		from 1 to n+1 */for (i in 2..n + 1) x2 = x2 xor i
        return x1 xor x2
    }

    /* program to test above function */
    @JvmStatic
    fun main(args: Array<String>) {
        val a = intArrayOf(1, 2, 4, 5, 6)
        val miss = getMissingNo(a, 5)
        println(miss)
    }
}
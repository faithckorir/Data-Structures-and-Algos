package data_structures.bitwise

import kotlin.jvm.JvmStatic
import data_structures.bitwise.LonelyInteger

// Java code to find the element
// that occur only once
internal object LonelyInteger {
    // Method to find the element that occur only once
    fun getSingle(arr: IntArray, n: Int): Int {
        var ones = 0
        var twos = 0
        var common_bit_mask: Int
        for (i in 0 until n) {
            /*"one & arr[i]" gives the bits that are there in
			both 'ones' and new element from arr[]. We
			add these bits to 'twos' using bitwise OR*/
            twos = twos or (ones and arr[i])

            /*"one & arr[i]" gives the bits that are
			there in both 'ones' and new element from arr[].
			We add these bits to 'twos' using bitwise OR*/ones = ones xor arr[i]

            /* The common bits are those bits which appear third time
			So these bits should not be there in both 'ones' and 'twos'.
			common_bit_mask contains all these bits as 0, so that the bits can
			be removed from 'ones' and 'twos'*/common_bit_mask = (ones and twos).inv()

            /*Remove common bits (the bits that appear third time) from 'ones'*/ones = ones and common_bit_mask

            /*Remove common bits (the bits that appear third time) from 'twos'*/twos = twos and common_bit_mask
        }
        return ones
    }

    // Driver method
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(3, 3, 2, 3)
        val n = arr.size
        println("The element with single occurrence is " + getSingle(arr, n))
    }
}
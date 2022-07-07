package data_structures.arrays

import java.util.Collections
import java.util.Arrays
import kotlin.jvm.JvmStatic
import data_structures.arrays.LeftRotateArray

// Java implementation for print left
// rotation of any array K times
internal object LeftRotateArray {
    // Function for the k times left rotation
    fun leftRotate(
        arr: Array<Int>, k: Int,
        n: Int
    ) {

        // In Collection class rotate function
        // takes two parameters - the name of
        // array and the position by which it
        // should be rotated
        // The below function will be rotating
        // the array left in linear time

        // Collections.rotate()rotate the
        // array from right hence n-k
        val list = arr.toList()
        Collections.rotate(list, n - k)

        // Print the rotated array from start position
        for (i in 0 until n) print(list[i].toString() + " ")
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = arrayOf(1, 3, 5, 7, 9)
        val n = arr.size
        val k = 2

        // Function call
        leftRotate(arr, k, n)
    }
}
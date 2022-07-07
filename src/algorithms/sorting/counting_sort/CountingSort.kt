package algorithms.sorting.counting_sort

import kotlin.jvm.JvmStatic
import algorithms.sorting.counting_sort.CountingSort

// Java implementation of Counting Sort
internal class CountingSort {
    fun sort(arr: CharArray) {
        val n = arr.size

        // The output character array that will have sorted arr
        val output = CharArray(n)

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        val count = IntArray(256)
        for (i in 0..255) count[i] = 0

        // store count of each character
        for (i in 0 until n) ++count[arr[i].code]

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (i in 1..255) count[i] += count[i - 1]

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (i in n - 1 downTo 0) {
            output[count[arr[i].code] - 1] = arr[i]
            --count[arr[i].code]
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (i in 0 until n) arr[i] = output[i]
    }

    companion object {
        // Driver method
        @JvmStatic
        fun main(args: Array<String>) {
            val ob = CountingSort()
            val arr = charArrayOf(
                'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
            )
            ob.sort(arr)
            print("Sorted character array is ")
            for (i in arr.indices) print(arr[i])
        }
    }
}
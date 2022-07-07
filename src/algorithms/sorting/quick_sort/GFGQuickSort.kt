package algorithms.sorting.quick_sort

import algorithms.sorting.quick_sort.GFGQuickSort
import kotlin.jvm.JvmStatic

// Java implementation of QuickSort
internal object GFGQuickSort {
    // A utility function to swap two elements
    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    /* This function takes last element as pivot, places
the pivot element at its correct position in sorted
array, and places all smaller (smaller than pivot)
to left of pivot and all greater elements to right
of pivot */
    fun partition(arr: IntArray, low: Int, high: Int): Int {

        // pivot
        val pivot = arr[high]

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        var i = low - 1
        for (j in low until high) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++
                swap(arr, i, j)
            }
        }
        swap(arr, i + 1, high)
        return i + 1
    }

    /* The main function that implements QuickSort
		arr[] --> Array to be sorted,
		low --> Starting index,
		high --> Ending index
*/
    fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            val pi = partition(arr, low, high)

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
    }

    // Function to print an array
    fun printArray(arr: IntArray, size: Int) {
        for (i in 0 until size) print(arr[i].toString() + " ")
        println()
    }

    // Driver Code
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(10, 7, 8, 9, 1, 5)
        val n = arr.size
        quickSort(arr, 0, n - 1)
        println("Sorted array: ")
        printArray(arr, n)
    }
}
package data_structures.bitwise

import kotlin.jvm.JvmStatic
import data_structures.bitwise.SignificantBit

// Simple Java program to find
// MSB number for given n.
internal object SignificantBit {
    fun setBitNumber(n: Int): Int {
        var n = n
        if (n == 0) return 0
        var msb = 0
        n = n / 2
        while (n != 0) {
            n = n / 2
            msb++
        }
        return 1 shl msb
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 0
        println(setBitNumber(n))
    }
}
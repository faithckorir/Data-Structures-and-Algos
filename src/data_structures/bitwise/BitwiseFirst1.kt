package data_structures.bitwise

import kotlin.jvm.JvmStatic
import data_structures.bitwise.BitwiseFirst1

// Java Code for Position of rightmost set bit
internal object BitwiseFirst1 {
    fun getFirstSetBitPos(n: Int): Int {
        return (Math.log10((n and -n).toDouble()) / Math.log10(2.0)).toInt() + 1
    }

    // Drive code
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 12
        println(getFirstSetBitPos(n))
    }
}
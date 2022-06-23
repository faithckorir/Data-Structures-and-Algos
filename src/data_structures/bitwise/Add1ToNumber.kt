package data_structures.bitwise

import kotlin.jvm.JvmStatic
import data_structures.bitwise.Add1ToNumber

// Java code to add
// one to a given number
internal object Add1ToNumber {
    fun addOne(x: Int): Int {
        var x = x
        var m = 1

        // Flip all the set bits
        // until we find a 0
        while ((x and m) >= 1) {
            x = x xor m
            m = m shl 1
        }

        // flip the rightmost 0 bit
        x = x xor m
        return x
    }

    /* Driver program to test above functions*/
    @JvmStatic
    fun main(args: Array<String>) {
        println(addOne(13))
    }
}
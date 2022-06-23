package ownpractise.strings

import kotlin.jvm.JvmStatic
import ownpractise.strings.SubstringCount

// Java program to count number of substrings
// of a string
object SubstringCount {
    fun countNonEmptySubstr(str: String): Int {
        val n = str.length
        return n * (n + 1) / 2
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val s = "abaa"
        println(
            countNonEmptySubstr(s)
        )
    }
}
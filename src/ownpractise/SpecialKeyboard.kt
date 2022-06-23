package ownpractise

import ownpractise.SpecialKeyboard
import kotlin.jvm.JvmStatic

/* A recursive Java program to print
maximum number of A's using
following four keys */internal object SpecialKeyboard {
    // A recursive function that returns
    // the optimal length string for N keystrokes
    fun findoptimal(N: Int): Int {
        // The optimal string length is N
        // when N is smaller than 7
        if (N <= 6) return N

        // Initialize result
        var max = 0

        // TRY ALL POSSIBLE BREAK-POINTS
        // For any keystroke N, we need to
        // loop from N-3 keystrokes back to
        // 1 keystroke to find a breakpoint
        // 'b' after which we will have Ctrl-A,
        // Ctrl-C and then only Ctrl-V all the way.
        var b: Int
        b = N - 3
        while (b >= 1) {

            // If the breakpoint is s at b'th
            // keystroke then the optimal string
            // would have length
            // (n-b-1)*screen[b-1];
            val curr = (N - b - 1) * findoptimal(b)
            if (curr > max) max = curr
            b--
        }
        return max
    }

    // Driver program
    @JvmStatic
    fun main(args: Array<String>) {
        var N: Int

        // for the rest of the array we
        // will reply on the previous
        // entries to compute new ones
        N = 1
        while (N <= 20) {
            println("Maximum Number of A's with keystrokes is " + N + findoptimal(N))
            N++
        }
    }
}
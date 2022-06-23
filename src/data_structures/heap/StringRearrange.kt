package data_structures.heap

import data_structures.heap.StringRearrange
import kotlin.jvm.JvmStatic

/*package whatever //do not write package name here */
internal object StringRearrange {
    fun getMaxCountChar(count: IntArray): Char {
        var max = 0
        var ch = 0.toChar()
        for (i in 0..25) {
            if (count[i] > max) {
                max = count[i]
                ch = ('a'.code + i).toChar()
            }
        }
        return ch
    }

    fun rearrangeString(S: String): String {
        val n = S.length
        if (n == 0) return ""
        val count = IntArray(26)
        for (i in 0..25) {
            count[i] = 0
        }
        for (ch in S.toCharArray()) {
            count[ch.code - 'a'.code]++
        }
        val ch_max = getMaxCountChar(count)
        var maxCount = count[ch_max.code - 'a'.code]

        // check if the result is possible or not
        if (maxCount > (n + 1) / 2) return ""
        var res = ""
        for (i in 0 until n) {
            res += ' '
        }
        var ind = 0
        // filling the most frequently occurring char in the even
        // indices
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max + res.substring(ind + 1)
            ind = ind + 2
            maxCount--
        }
        count[ch_max.code - 'a'.code] = 0

        // now filling the other Chars, first filling the even
        // positions and then the odd positions
        for (i in 0..25) {
            while (count[i] > 0) {
                ind = if (ind >= n) 1 else ind
                res = res.substring(0, ind) + ('a'.code + i).toChar() + res.substring(ind + 1)
                ind += 2
                count[i]--
            }
        }
        return res
    }

    // Driver Code
    @JvmStatic
    fun main(args: Array<String>) {
        val str = "bbbaa"
        val res = rearrangeString(str)
        if (res === "") println("Not valid string") else println(res)
    }
}
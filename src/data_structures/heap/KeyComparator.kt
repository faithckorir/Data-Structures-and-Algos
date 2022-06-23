package data_structures.heap

import data_structures.heap.GFG
import data_structures.heap.KeyComparator
import java.util.*
import kotlin.jvm.JvmStatic

// Java program to rearrange characters in a string
// so that no two adjacent characters are same.
internal class KeyComparator : Comparator<Key> {
    // Overriding compare()method of Comparator
    override fun compare(k1: Key, k2: Key): Int {
        if (k1.freq < k2.freq) return 1 else if (k1.freq > k2.freq) return -1
        return 0
    }
}

internal class Key(// store frequency of character
    var freq: Int, var ch: Char
)

internal object GFG {
    var MAX_CHAR = 26

    // Function to rearrange character of a string
    // so that no char repeat twice
    private fun rearrangeString(word: String) {
        var str = word
        val n = str.length

        // Store frequencies of all characters in string
        val count = IntArray(MAX_CHAR)
        for (i in 0 until n) count[str[i] - 'a']++

        // Insert all characters with their frequencies
        // into a priority_queue
        val pq = PriorityQueue(KeyComparator())
        var c = 'a'
        while (c <= 'z') {
            val `val` = c - 'a'
            if (count[`val`] > 0) pq.add(Key(count[`val`], c))
            c++
        }

        // 'str' that will store resultant value
        str = ""

        // work as the previous visited element
        // initial previous element be. ( '#' and
        // it's frequency '-1' )
        var prev = Key(-1, '#')

        // traverse queue
        while (pq.size != 0) {

            // pop top element from queue and add it
            // to string.
            val k = pq.peek()
            pq.poll()
            str = str + k.ch

            // If frequency of previous character is less
            // than zero that means it is useless, we
            // need not to push it
            if (prev.freq > 0) pq.add(prev)

            // make current character as the previous 'char'
            // decrease frequency by 'one'
            k.freq--
            prev = k
        }

        // If length of the resultant string and original
        // string is not same then string is not valid
        if (n != str.length) println(" Not valid String ") else println(str)
    }

    // Driver program to test above function
    @JvmStatic
    fun main(args: Array<String>) {
        val str = "bbbaa"
        rearrangeString(str)
    }
}
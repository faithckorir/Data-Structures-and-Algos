package algorithms.recursion.backtrackingnRecursion

import kotlin.jvm.JvmStatic

// Java program to remove all adjacent duplicates from a
// string
internal object GFG {
    var last_removed //will store the last char removed during recursion
            = 0.toChar()

    // Recursively removes adjacent duplicates from str and
    // returns new string. last_removed is a pointer to
    // last_removed character
    fun removeUtil(str: String): String {

        // If length of string is 1 or 0
        var str = str
        if (str.length == 0 || str.length == 1) return str

        // Remove leftmost same characters and recur for
        // remaining string
        if (str[0] == str[1]) {
            last_removed = str[0]
            while (str.length > 1
                && str[0] == str[1]
            ) str = str.substring(1, str.length)
            str = str.substring(1, str.length)
            return removeUtil(str)
        }

        // At this point, the first character is definitely
        // different from its adjacent. Ignore first
        // character and recursively remove characters from
        // remaining string
        val rem_str = removeUtil(str.substring(1, str.length))

        // Check if the first character of the rem_string
        // matches with the first character of the original
        // string
        if (rem_str.length != 0
            && rem_str[0] == str[0]
        ) {
            last_removed = str[0]

            // Remove first character
            return rem_str.substring(1, rem_str.length)
        }

        // If remaining string becomes empty and last
        // removed character is same as first character of
        // original string. This is needed for a string like
        // "acbbcddc"
        return if (rem_str.length == 0
            && last_removed == str[0]
        ) rem_str else str[0].toString() + rem_str

        // If the two first characters of str and rem_str
        // don't match, append first character of str before
        // the first character of rem_str
    }

    fun remove(str: String): String {
        last_removed = '\u0000'
        return removeUtil(str)
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val str1 = "geeksforgeeg"
        println(remove(str1))
        val str2 = "azxxxzy"
        println(remove(str2))
        val str3 = "caaabbbaac"
        println(remove(str3))
        val str4 = "gghhg"
        println(remove(str4))
        val str5 = "aaaacddddcappp"
        println(remove(str5))
        val str6 = "aaaaaaaaaa"
        println(remove(str6))
        val str7 = "qpaaaaadaaaaadprq"
        println(remove(str7))
        val str8 = "acaaabbbacdddd"
        println(remove(str8))
    }
}
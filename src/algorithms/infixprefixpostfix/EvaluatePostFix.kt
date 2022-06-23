package algorithms.infixprefixpostfix

import kotlin.jvm.JvmStatic
import java.util.*

// Java program to evaluate value of a postfix expression
object EvaluatePostFix {
    // Method to evaluate value of a postfix expression
    fun evaluatePostfix(exp: String): Int {
        //create a stack
        val stack = Stack<Int>()

        // Scan all characters one by one
        for (element in exp) {

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if (Character.isDigit(element)) {

                stack.push(element - '0')
            }else {
                val val1 = stack.pop()
                val val2 = stack.pop()
                when (element) {
                    '+' -> stack.push(val2 + val1)
                    '-' -> stack.push(val2 - val1)
                    '/' -> stack.push(val2 / val1)
                    '*' -> stack.push(val2 * val1)
                }
            }
        }
        return stack.pop()
    }

    // Driver program to test above functions
    @JvmStatic
    fun main(args: Array<String>) {
        val exp = "231*+9-"
        println("postfix evaluation: " + evaluatePostfix(exp))
    }
}
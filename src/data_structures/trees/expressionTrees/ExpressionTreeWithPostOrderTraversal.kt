package data_structures.trees.expressionTrees

import java.util.*
import kotlin.jvm.JvmStatic

class Node(var data: Char) {
    var left: Node?
    var right: Node? = null

    init {
        left = right
    }
}

object Main {
    fun isOperator(ch: Char): Boolean {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'
    }

    private fun expressionTree(postfix: String): Node {
        val st = Stack<Node>()
        var t1: Node?
        var t2: Node?
        var temp: Node
        for (i in 0 until postfix.length) {
            if (!isOperator(postfix[i])) {
                temp = Node(postfix[i])
                st.push(temp)
            } else {
                temp = Node(postfix[i])
                t1 = st.pop()
                t2 = st.pop()
                temp.left = t2
                temp.right = t1
                st.push(temp)
            }
        }
        temp = st.pop()
        return temp
    }

    fun inorder(root: Node?) {
        if (root == null) return
        inorder(root.left)
        print(root.data)
        inorder(root.right)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val postfix = "ABC*+D/"
        val r = expressionTree(postfix)
        inorder(r)
    }
}
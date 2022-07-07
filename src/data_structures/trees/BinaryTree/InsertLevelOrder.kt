package data_structures.trees.BinaryTree

import kotlin.jvm.JvmStatic

// Java program to construct binary tree from
// given array in level order fashion
class InsertLevelOrder {
    var root: Node? = null

    // Tree Node
    class Node(var data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    // Function to insert nodes in level order
    fun insertLevelOrder(arr: IntArray, i: Int): Node? {
        var current: Node? = null
        // Base case for recursion
        if (i < arr.size) {
            current = Node(arr[i])

            // insert left child
            current.left = insertLevelOrder(arr, 2 * i + 1)

            // insert right child
            current.right = insertLevelOrder(arr, 2 * i + 2)
        }
        return current
    }

    // Function to print tree nodes in InOrder fashion
    fun inOrder(root: Node?) {
        if (root != null) {
            inOrder(root.left)
            print(root.data.toString() + " ")
            inOrder(root.right)
        }
    }

    companion object {
        // Driver program to test above function
        @JvmStatic
        fun main(args: Array<String>) {
            val t2 = InsertLevelOrder()
            val arr = intArrayOf(1, 2, 3, 4, 5, 6, 6, 6, 6)
            t2.root = t2.insertLevelOrder(arr, 0)
            t2.inOrder(t2.root)
        }
    }
}
package data_structures.trees.BinaryTree

import java.util.*

// Java program to find height of tree
// A binary tree node
internal class Node(var data: Int) {
    var left: Node?
    var right: Node? = null

    init {
        left = right
    }
}

internal class BinaryTree {
    var root: Node? = null

    /* Compute the "maxDepth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    fun maxDepth(node: Node?): Int {
        return if (node == null) {
            0
        } else {
            val queue: Queue<Node> = LinkedList<Node>()

            /* compute the depth of each subtree */
            val lDepth = maxDepth(node.left)
            val rDepth = maxDepth(node.right)

            /* use the larger one */if (lDepth > rDepth) lDepth + 1 else rDepth + 1
        }
    }

    companion object {
        /* Driver program to test above functions */
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BinaryTree()
            tree.root = Node(1)
            tree.root!!.left = Node(2)
            tree.root!!.right = Node(3)
            tree.root!!.left!!.left = Node(4)
            tree.root!!.left!!.right = Node(5)
            println(
                "Height of tree is : " +
                        tree.maxDepth(tree.root)
            )
        }
    }
}
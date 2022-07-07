package data_structures.trees.BinaryTree.geeksforgeeks

import kotlin.jvm.JvmStatic

// Class containing left and right child
// of current node and key value
internal class Node(var key: Int) {
    var left: Node?
    var right: Node? = null

    init {
        left = right
    }
} // A Java program to introduce Binary Tree

internal class BinaryTree {
    // Root of Binary Tree
    var root: Node?

    // Constructors
    constructor(key: Int) {
        root = Node(key)
    }

    constructor() {
        root = null
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BinaryTree()

            // create root
            tree.root = Node(1)

            /* following is the tree after above statement

			1
			/ \
		null null	 */tree.root!!.left = Node(2)
            tree.root!!.right = Node(3)

            /* 2 and 3 become left and right children of 1
			1
			/	 \
		2	 3
		/ \	 / \
	null null null null */tree.root!!.left!!.left = Node(4)
            /* 4 becomes left child of 2
					1
				/	 \
			2		 3
			/ \	 / \
			4 null null null
		/ \
		null null
		*/
        }
    }
}
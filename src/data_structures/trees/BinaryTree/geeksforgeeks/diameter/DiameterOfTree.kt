package data_structures.trees.BinaryTree.geeksforgeeks.diameter

// Recursive optimized Java program to find the diameter of
// a Binary Tree
// Class containing left and right child of current
// node and key value
internal class Node(var data: Int) {
    var left: Node?
    var right: Node? = null

    init {
        left = right
    }
} // Class to print the Diameter

internal class BinaryTree {
    var root: Node? = null

    // Method to calculate the diameter and return it to
    // main
    // A wrapper over diameter(Node root)
    @JvmOverloads
    fun diameter(root: Node? = this.root): Int {
        // base case if tree is empty
        if (root == null) {
            return 0
        }

        // get the height of left and right sub-trees
        val lheight = height(root.left)
        val rheight = height(root.right)

        // get the diameter of left and right sub-trees
        val ldiameter = diameter(root.left)
        val rdiameter = diameter(root.right)

        /* Return max of following three
		1) Diameter of left subtree
		2) Diameter of right subtree
		3) Height of left subtree + height of right subtree + 1
		*/return Math.max(
            lheight + rheight + 1,
            Math.max(ldiameter, rdiameter)
        )
    }

    companion object {
        // The function Compute the "height" of a tree. Height
        // is the number of nodes along the longest path from the
        // root node down to the farthest leaf node.
        fun height(node: Node?): Int {
            // base case tree is empty
            return if (node == null) 0 else 1 +
            Math.max(
                height(node!!.left),
                height(node!!.right)
            )

            // If tree is not empty then height = 1 + max of
            // left height and right heights
        }

        // Driver Code
        @JvmStatic
        fun main(args: Array<String>) {
            // creating a binary tree and entering the nodes
            val tree = BinaryTree()
            tree.root = Node(1)
            tree.root!!.left = Node(2)
            tree.root!!.right = Node(3)
            tree.root!!.left!!.left = Node(4)
            tree.root!!.left!!.right = Node(5)

            // Function Call
            println(
                "The diameter of given binary tree is : "
                        + tree.diameter()
            )
        }
    }
}
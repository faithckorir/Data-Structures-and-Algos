package data_structures.trees.treefrompreorderinorder

import kotlin.jvm.JvmStatic

// Java program to construct a tree using inorder and preorder traversal
/* A binary tree node has data, pointer to left child
and a pointer to right child */
internal class Node(var data: Char) {
    var left: Node? = null
    var right: Node? = null
}

internal class BinaryTree {
    var root: Node? = null

    /* Recursive function to construct binary of size len from
	Inorder traversal in[] and Preorder traversal pre[].
	Initial values of inStrt and inEnd should be 0 and len -1.
	The function doesn't do any error checking for cases where
	inorder and preorder do not form a tree */
    fun buildTree(inOrderArray: CharArray, preOrderArray: CharArray, inStrt: Int, inEnd: Int): Node? {
        if (inStrt > inEnd) return null

        /* Pick current node from Preorder traversal using preIndex
		and increment preIndex */
        val tNode = Node(preOrderArray[preIndex++])

        /* If this node has no children then return */if (inStrt == inEnd) return tNode

        /* Else find the index of this node in Inorder traversal */
        val inIndex = search(inOrderArray, inStrt, inEnd, tNode.data)

        /* Using index in Inorder traversal, construct left and
		right subtress */tNode.left = buildTree(inOrderArray, preOrderArray, inStrt, inIndex - 1)
        tNode.right = buildTree(inOrderArray, preOrderArray, inIndex + 1, inEnd)
        return tNode
    }

    /* UTILITY FUNCTIONS */ /* Function to find index of value in arr[start...end]
	The function assumes that value is present in in[] */
    fun search(arr: CharArray, strt: Int, end: Int, value: Char): Int {
        var i: Int
        i = strt
        while (i <= end) {
            if (arr[i] == value) return i
            i++
        }
        return i
    }

    /* This function is here just to test buildTree() */
    fun printInorder(node: Node?) {
        if (node == null) return

        /* first recur on left child */printInorder(node.left)

        /* then print the data of node */print(node.data.toString() + " ")

        /* now recur on right child */printInorder(node.right)
    }

    companion object {
        var preIndex = 0

        // driver program to test above functions
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BinaryTree()
            val `in` = charArrayOf('D', 'B', 'E', 'A', 'F', 'C')
            val pre = charArrayOf('A', 'B', 'D', 'E', 'C', 'F')
            val len = `in`.size
            val root = tree.buildTree(`in`, pre, 0, len - 1)

            // building the tree by printing inorder traversal
            println("Inorder traversal of constructed tree is : ")
            tree.printInorder(root)
        }
    }
}
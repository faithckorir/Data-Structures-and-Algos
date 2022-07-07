package data_structures.trees.BinaryTree.geeksforgeeks.diameter

import java.util.*
import kotlin.jvm.JvmStatic

// Java program to insert element in binary tree
object InsertToAbinaryTree {
    var root: Node? = null


    /* Inorder traversal of a binary tree*/
    fun inorder(temp: Node?) {
        if (temp == null) return
        inorder(temp.left)
        print(temp.key.toString() + " ")
        inorder(temp.right)
    }

    /*function to insert element in binary tree */
    fun insert(rootNode: Node?, key: Int) {
        var tempRoot = rootNode
        if (tempRoot == null) {
            root = Node(key)
            return
        }
        val q: Queue<Node?> = LinkedList()
        q.add(tempRoot)

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            tempRoot = q.peek()
            q.remove()
            if (tempRoot!!.left == null) {
                tempRoot.left = Node(key)
                break
            } else{
                q.add(tempRoot.left)
            }
            if (tempRoot.right == null) {
                tempRoot.right = Node(key)
                break
            } else{ q.add(tempRoot.right)}
        }
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        root = Node(10)
        root!!.left = Node(11)
        root!!.left!!.left = Node(7)
        root!!.right = Node(9)
        root!!.right!!.left = Node(15)
        root!!.right!!.right = Node(8)
        print(
            "Inorder traversal before insertion:"
        )
        inorder(root)
        val key = 12
        insert(root, key)
        print(
            "\nInorder traversal after insertion:"
        )
        inorder(root)
    }

    /* A binary tree node has key, pointer to
	left child and a pointer to right child */
    class Node     // constructor
        (var key: Int) {
        var left: Node? = null
        var right: Node? = null
    }
}
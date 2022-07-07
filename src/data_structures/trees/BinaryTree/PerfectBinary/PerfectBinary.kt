import data_structures.trees.BinaryTree.geeksforgeeks.diameter.InsertToAbinaryTree
import java.util.*

fun main() {
    println("What is the number of nodes in the tree")
    var nodes = readLine()!!.trimEnd().toInt()
    val bTree = BTree()
    for (i in 0 until nodes) {
        println("Input the ${i + 1} Node")
        val nodeKey = readLine()!!.trimEnd().toInt()
        bTree.insert(nodeKey)
    }
    bTree.sum()
    bTree.sumParent(2)
    bTree.printPreOrder(bTree.root)

}

class BNode(var data: Int) {
    var left: BNode? = null
    var right: BNode? = null
}

class BTree {
    var root: BNode? = null

    fun insert(key: Int) {
        var tempRoot = root
        if (tempRoot == null) {
            root = BNode(key)
            return
        }
        val q: Queue<BNode> = LinkedList()
        q.add(tempRoot)

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            tempRoot = q.remove()

            if (tempRoot!!.left == null) {
                tempRoot.left = BNode(key)
                return
            } else{
                q.add(tempRoot.left)
            }
            if (tempRoot.right == null) {
                tempRoot.right = BNode(key)
                return
            } else{ q.add(tempRoot.right)}
        }

    }
    fun sumParent(child:Int){
        if(root == null){
            println(0)
            return
        }
        var sum = 0
        var current = root
        val q:Queue<BNode> = LinkedList()
        q.add(current)

        while(!q.isEmpty()){
            current = q.remove()
            if(current.left != null && current.left?.data == child ){
                sum += current.data!!
            }
            if(current.right != null && current.right?.data == child ){
                sum += current.data!!
            }

        }
        println("Parent Sum is $sum")
    }
    fun sum(){
        if(root == null){
            println(0)
            return
        }
        val q: Queue<BNode> = LinkedList()
        var current = root
        var sum = 0
        q.add(current)

        while(!q.isEmpty()){
            current = q.remove()
            if(current != null){
                sum += current.data
            }
            if(current.left != null){
                q.add(current.left)
            }
            if(current.right != null){
                q.add(current.right)
            }
        }
        println("Sum is $sum")

    }

    fun printPreOrder(root: BNode?) {
        if (root == null) {
           // println(-1)
            return
        }
        println(root.data)
        printPreOrder(root.left)
        printPreOrder(root.right)


    }
}


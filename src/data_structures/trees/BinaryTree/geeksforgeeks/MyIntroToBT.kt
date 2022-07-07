package data_structures.trees.BinaryTree.geeksforgeeks

import java.util.*

class BinaryNode(var data: Int) {
    var left: BinaryNode? = null
    var right: BinaryNode? = null

}


fun main() {

    var root: BinaryNode? = null
    root = BinaryNode(1)
    root.left = BinaryNode(2)
    root.right = BinaryNode(3)
    root.left!!.left = BinaryNode(4)
    println("Doing Pre Order \n")
    doPreOrderTraversal(root)
    println("doing in order\n")

    doInorder(root)
    println("do post order\n")
    doPostOrder(root)
    doInorder(root)
    val newroot = insertKey(root,5)
    println("\ninddf")
    doInorder(newroot)



}

fun insertKey(root: BinaryNode, i: Int) :BinaryNode {
    var currentHead = root
    val newNode = BinaryNode(i)
    if(currentHead == null){
        return newNode

    }

    val q: Queue<BinaryNode> = LinkedList()
    q.add(currentHead)

    while(!q.isEmpty()){
        currentHead = q.remove()
        if(currentHead.left == null){
            currentHead.left = newNode
            break
        }else{
            q.add(currentHead.left)
        }

        if(currentHead.right == null){
            currentHead.right = newNode
            break
        }else{
            q.add(currentHead.right)
        }

    }



    return root

}

fun doPreOrderTraversal(root: BinaryNode?) {
    //root,left,right
    if (root == null) {
        return
    }

    print(root.data)
    doPreOrderTraversal(root.left)
    doPreOrderTraversal(root.right)

}

fun deleteNode(root: BinaryNode?, key: Int) : BinaryNode {
    if(root == null){
        return BinaryNode(-1)
    }
    if(root.data == key){
        return root
    }

    while(root.data != key){
        deleteNode(root.left,5)

    }
    while(root.data != key){
        deleteNode(root.left,5)

    }


    return root


}


fun doInorder(root: BinaryNode?) {
    //root,left,right
    if (root == null) {
        return
    }


    doInorder(root.left)
    print(root.data)
    doInorder(root.right)

}

fun doPostOrder(root: BinaryNode?) {
    //root,left,right
    if (root == null) {
        return
    }


    doPostOrder(root.left)
    doPostOrder(root.right)
    print(root.data)

}

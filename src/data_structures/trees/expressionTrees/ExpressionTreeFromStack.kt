import java.util.*

class Node (var c : Char){
    var right: Node? = null
    var left: Node? = null
}

fun main(){
    val exp = "1 2 3*+ 4/".filterNot { it.isWhitespace() }
    val root = makeTree(exp)
    println("infix")
    printInfix(root)
    println("\nprefix")

    printPreFix(root)
    println("\npostfix")

    printPostFix(root)


}

fun printPostFix(root: Node?) {
    val current = root ?: return

    printPostFix(current.left)
    printPostFix(current.right)
    //println("PostFix Expression")
    print( current.c)
}
fun printPreFix(root: Node?) {
    val current = root ?: return
    //println("Prefix Expression")
    print( current.c)
    printPostFix(current.left)
    printPostFix(current.right)


}
fun printInfix(root: Node?) {
    val current = root ?: return
    //println("InFix Expression")

    printPostFix(current.left)
    print( current.c)
    printPostFix(current.right)


}

fun makeTree(exp: String) :Node{
    val stack = Stack<Node>()

    for (c in exp){
        val node = Node(c)
        if(Character.isDigit(c)){
            node.left = null
            node.right = null



        }else{
            val d1 = stack.pop()
            val d2 = stack.pop()
            node.left = d2
            node.right = d1

        }
        stack.push(node)
    }


    return stack.pop()



}

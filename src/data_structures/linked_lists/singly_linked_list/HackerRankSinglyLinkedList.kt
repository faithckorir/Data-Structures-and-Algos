package data_structures.linked_lists.singly_linked_list

import java.util.*

object HackerRankSinglyLinkedList {
    // Complete the printLinkedList function below.
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    fun printLinkedList(head: SinglyLinkedListNode?) {
        var current = head
        while (current != null) {
            println(current.data)
            current = current.next
        }
    }

    private val scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        val llist = SinglyLinkedList()
        val llistCount = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until llistCount) {
            val llistItem = scanner.nextInt()
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
            llist.insertNode(llistItem)
        }
        printLinkedList(llist.head)
        scanner.close()
    }

    class SinglyLinkedListNode(var data: Int) {
        var next: SinglyLinkedListNode? = null
    }

    internal class SinglyLinkedList {
        var head: SinglyLinkedListNode? = null
        var tail: SinglyLinkedListNode? = null
        fun insertNode(nodeData: Int) {
            val node = SinglyLinkedListNode(nodeData)
            if (head == null) {
                head = node
            } else {
                tail!!.next = node
            }
            tail = node
        }
    }
}
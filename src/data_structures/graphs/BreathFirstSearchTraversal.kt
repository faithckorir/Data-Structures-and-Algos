package data_structures.graphs

import java.util.*

// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
// This class represents a directed graph using adjacency list
// representation
internal class BreathFirstSearchTraversal(  // No. of vertices
    private val V: Int
) {
    private val adj: Array<LinkedList<Int>?> = arrayOfNulls(V) //Adjacency Lists

    // Constructor
    init {

        for (i in 0 until V) adj[i] = LinkedList<Int>()
    }

    // Function to add an edge into the graph
    fun addEdge(v: Int, w: Int) {
        adj[v]!!.add(w)
    }

    // prints BFS traversal from a given source s
    fun BFS(s: Int) {
        // Mark all the vertices as not visited(By default
        // set as false)
        var s = s
        val visited = BooleanArray(V)

        // Create a queue for BFS
        val queue = LinkedList<Int>()

        // Mark the current node as visited and enqueue it
        visited[s] = true
        queue.add(s)
        while (queue.size != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll()
            print("$s ")

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            val i: Iterator<Int> = adj[s]!!.listIterator()
            while (i.hasNext()) {
                val n = i.next()
                if (!visited[n]) {
                    visited[n] = true
                    queue.add(n)
                }
            }
        }
    }

    companion object {
        // Driver method to
        @JvmStatic
        fun main(args: Array<String>) {
            val g = BreathFirstSearchTraversal(4)
            g.addEdge(0, 1)
            g.addEdge(0, 2)
            g.addEdge(1, 2)
            g.addEdge(2, 0)
            g.addEdge(2, 3)
            g.addEdge(3, 3)
            println(
                "Following is Breadth First Traversal " +
                        "(starting from vertex 2)"
            )
            g.BFS(2)
        }
    }
}
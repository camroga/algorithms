package graph

import arrays.Node
import java.util.ArrayDeque

fun cloneGraph(node: Node?): Node? {
    if (node == null) return null

    // Map to store original node -> cloned node mapping
    val visited = mutableMapOf<Node, Node>()
    val queue = ArrayDeque<Node>().apply {
        add(node)
    }

    visited[node] = Node(node.`val`) // Clone the root node

    while (queue.isNotEmpty()) {
        val current = queue.pop()

        for (neighbor in current.neighbors) {
            if (!visited.contains(neighbor) && neighbor != null) {
                // Clone the neighbor if not already cloned
                visited[neighbor] = Node(neighbor.`val`)
                queue.push(neighbor) // Add original neighbor to the queue for further traversal
            }
            // Add the cloned neighbor to the current cloned node's neighbors
            visited[current]?.neighbors?.add(visited[neighbor])
        }
    }

    return visited[node]
}

fun main() {
    val node1 = Node(`val` = 1)
    val node2 = Node(`val` = 2)
    val node3 = Node(`val` = 3)
    val node4 = Node(`val` = 4)
    println(cloneGraph(node1.apply {
        neighbors = arrayListOf(
            node2.apply {
                neighbors = arrayListOf(
                    node1,
                    node3.apply {
                        neighbors = arrayListOf(node2, node4)
                    })
            },
            node4.apply {
                neighbors = arrayListOf(
                    node1,
                    node3.apply {
                        neighbors = arrayListOf(node2, node4)
                    })
            })
    }))
}
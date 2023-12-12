package graph

import binary_tree.BinaryTree

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        val names = mutableListOf<String>()
        names.add(name)
        children.forEach { child ->
            names.addAll(child.depthFirstSearch())
        }
        return names
    }
}

fun main() {
    val root = Node(name = "1").apply {
        children.addAll(mutableListOf(
            Node("2").apply {
                children.addAll(mutableListOf(Node("3")))
            },
            Node("4"))
        )
    }
    print(root.depthFirstSearch())
}
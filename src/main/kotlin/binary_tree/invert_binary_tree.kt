package binary_tree

import java.util.Stack


fun invertBinaryTree(tree: BinaryTree) {
    //BFS
    val stack = Stack<BinaryTree>()
    stack.add(tree)
    while (stack.isNotEmpty()) {
        val ce = stack.pop()
        val left = ce.left
        val right = ce.right
        ce.left = right
        ce.right = left
        if (left != null) {
            stack.add(left)
        }
        if (right != null) {
            stack.add(right)
        }
    }
}

fun main(args: Array<String>) {
    val root = BinaryTree(1)
    root.left = BinaryTree(2)
    root.left!!.left = BinaryTree(4)
    root.left!!.left!!.left = BinaryTree(8)
    root.left!!.left!!.right = BinaryTree(9)
    root.left!!.right = BinaryTree(5)
    root.right = BinaryTree(3)
    root.right!!.left = BinaryTree(6)
    root.right!!.right = BinaryTree(7)
    invertBinaryTree(root)
    print(root)
}
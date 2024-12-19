package binary_tree

import java.util.*


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

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun invertTree(root: TreeNode?): TreeNode? {
    // Invert the tree recursively
    invertTreeRecursive(root)
    return root
}

fun invertTreeRecursive(node: TreeNode?) {
    // Base case: if the node is null, do nothing
    if (node == null) return
    // Swap the left and right children
    node.left = node.right.also { node.right = node.left }
    // Recurse on the left and right subtrees
    invertTreeRecursive(node.left)
    invertTreeRecursive(node.right)
}

fun main() {
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
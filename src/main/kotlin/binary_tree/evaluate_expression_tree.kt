package binary_tree

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}


fun evaluateExpressionTree(tree: BinaryTree): Int {
    if (tree.value >= 0 || tree.left == null || tree.right == null) {
        return tree.value
    }
    val left = evaluateExpressionTree(tree.left!!)
    val right = evaluateExpressionTree(tree.right!!)
    return when (tree.value) {
        -1 -> left + right
        -2 -> left - right
        -3 -> left / right
        -4 -> left * right
        else -> left + right
    }
}

fun main() {
    val root = BinaryTree(value = -1).apply {
        left = BinaryTree(value = -2).apply {
            left = BinaryTree(value = -4).apply {
                left = BinaryTree(value = 2)
                right = BinaryTree(value = 3)
            }
            right = BinaryTree(value = 2)
        }
        right = BinaryTree(value = -3).apply {
            left = BinaryTree(value = 8)
            right = BinaryTree(value = 3)
        }
    }
    print(evaluateExpressionTree(root))
}
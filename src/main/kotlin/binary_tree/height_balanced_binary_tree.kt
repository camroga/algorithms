package binary_tree

var isBalanced = true

fun heightBalancedBinaryTree(tree: BinaryTree): Boolean {
    // Write your code here.
    dfs(tree, 0)
    return isBalanced
}

fun dfs(node: BinaryTree?, height: Int): Int {
    if (node == null) return height
    val left = dfs(node.left, height + 1)
    val right = dfs(node.right, height + 1)
    if (isBalanced) isBalanced = Math.abs(left - right) < 2
    return Math.max(left, right)
}

fun isBalanced(root: TreeNode?): Boolean {
    return getMaxHeight(root) != -1
}

fun getMaxHeight(node: TreeNode?): Int {
    if (node == null) return 0
    val left = getMaxHeight(node.left)
    if (left == -1) return -1
    val right = getMaxHeight(node.right)
    if (right == -1) return -1
    if (Math.abs(left - right) > 1) return -1
    return Math.max(right, left) + 1
}

fun main(args: Array<String>) {
    val root = BinaryTree(value = 1).apply {
        left = BinaryTree(2).apply {
            left = BinaryTree(4)
            right = BinaryTree(5).apply {
                left = BinaryTree(7)
                right = BinaryTree(8)
            }
        }
        right = BinaryTree(3).apply {
            left = BinaryTree(11)
            right = BinaryTree(6).apply {
                left = BinaryTree(9)
                right = BinaryTree(10)
            }
        }
    }
    println(heightBalancedBinaryTree(root))
}
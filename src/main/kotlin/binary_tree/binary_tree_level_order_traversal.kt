import binary_tree.BinaryTree
import java.util.ArrayDeque;


fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf<List<Int>>()
    // bfs
    var queue = mutableListOf<TreeNode>(root)
    val lo = mutableListOf<MutableList<Int>>()

    while (queue.isNotEmpty()) {
        val newLevel = mutableListOf<TreeNode>()
        val current = mutableListOf<Int>()
        queue.forEach { node ->
            current.add(node.`val`)
            node.left?.let { left -> newLevel.add(left) }
            node.right?.let { right -> newLevel.add(right) }
        }
        queue = newLevel
        lo.add(current)
    }
    return lo
}


fun main(args: Array<String>) {
    val root = TreeNode(1).apply {
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
    }
    print(levelOrder(root = root))
}

package binary_tree

import java.util.*

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null || q == null) return p == q

    val stackP = ArrayDeque<TreeNode>().apply { push(p) }
    val stackQ = ArrayDeque<TreeNode>().apply { push(q) }

    while (stackP.isNotEmpty() && stackQ.isNotEmpty()) {
        val nodeP = stackP.pop()
        val nodeQ = stackQ.pop()

        if (nodeP.`val` != nodeQ.`val`) return false

        if (nodeP.left != null && nodeQ.left != null) {
            stackP.push(nodeP.left!!)
            stackQ.push(nodeQ.left!!)
        } else if (nodeP.left != nodeQ.left) return false

        if (nodeP.right != null && nodeQ.right != null) {
            stackP.push(nodeP.right!!)
            stackQ.push(nodeQ.right!!)
        } else if (nodeP.right != nodeQ.right) return false
    }

    return stackP.isEmpty() && stackQ.isEmpty()
}

fun main(args: Array<String>) {
    val p = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    val q = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    println(isSameTree(p, q))
}
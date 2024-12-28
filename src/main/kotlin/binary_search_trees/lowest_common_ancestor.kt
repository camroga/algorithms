package binary_search_trees


class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    // Base case: If root is null, p, or q, return root
    if (root == null || root.`val` == p?.`val` || root.`val` == q?.`val`) {
        return root
    }

    // Search in left and right subtrees
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    // If p and q are found in different subtrees, root is their LCA
    if (left != null && right != null) {
        return root
    }

    // Otherwise, return the non-null result (either left or right)
    return left ?: right
}

fun main(args: Array<String>) {
    println(
        lowestCommonAncestor(
            root = TreeNode(`val` = 6).apply {
                left = TreeNode(`val` = 2).apply {
                    left = TreeNode(`val` = 0)
                    right = TreeNode(`val` = 4).apply {
                        left = TreeNode(`val` = 3)
                        right = TreeNode(`val` = 5)
                    }
                }
                right = TreeNode(`val` = 8).apply {
                    left = TreeNode(`val` = 7)
                    right = TreeNode(`val` = 9)
                }
            },
            p = TreeNode(`val` = 2),
            q = TreeNode(`val` = 8)
        )?.`val`
    )
}
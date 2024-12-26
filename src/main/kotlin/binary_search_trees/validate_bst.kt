class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
//
//fun isValidBST(root: TreeNode?): Boolean {
//    if (root == null) return true
//    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
//}
//
//fun isValidBST(node: TreeNode?, min: Long, max: Long): Boolean {
//    if (node == null) return true
//    return if (node.`val` in min + 1 until max) {
//        isValidBST(node.left, min, node.`val`.toLong()) &&
//                isValidBST(node.right, node.`val`.toLong(), max)
//    } else false
//}
//
//fun main() {
//    //[5,4,6,null,null,3,7] [3,1,5,0,2,4,6]
//    var root = TreeNode(5).apply {
//        left = TreeNode(4).apply {
////            left = TreeNode(0).apply {}
////            right = TreeNode(2).apply {}
//        }
//        right = TreeNode(6).apply {
//            left = TreeNode(3)
//            right = TreeNode(7)
//        }
//    }
//    //[2,1,3] [3,null,30,10,null,null,15,null,45]
//    /*root = TreeNode(3).apply {
//        right = TreeNode(30).apply {
//            left = TreeNode(10).apply {
//                right = TreeNode(15).apply {
//                    right = TreeNode(45)
//                }
//            }
//        }
//    }*/
//    root = TreeNode(2).apply {
//        right = TreeNode(2)
//        left = TreeNode(2)
//    }
//    print(isValidBST(root = root))
//}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun validateBst(tree: BST): Boolean {
    return dfs(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun dfs(tree: BST?, min: Int, max: Int): Boolean {
    if (tree == null) return true

    if (tree.value < min || tree.value >= max) return false

    // 5 -MIN 10
    return dfs(tree.left, min, tree.value) ||
            // 15 10 MAX
            dfs(tree.right, tree.value, max)
}


fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE)
}

fun isValidBST(node: TreeNode?, max: Long, min: Long): Boolean {
    if (node == null) return true
    if (node.`val` != Int.MAX_VALUE &&
        node.`val` != Int.MIN_VALUE &&
        (node.`val` <= min || node.`val` >= max)) return false


    return isValidBST(node.left, node.`val`.toLong(), min) &&
            isValidBST(node.right, max, node.`val`.toLong())
}

fun main(args: Array<String>) {
    val tree = BST(10)
    tree.left = BST(5)
    tree.left!!.left = BST(2)
    tree.left!!.left!!.left = BST(1)
    tree.left!!.right = BST(5)

    tree.right = BST(15)
    tree.right!!.left = BST(13)
    tree.right!!.left!!.right = BST(14)
    tree.right!!.right = BST(22)


    val result = validateBst(tree)
    assert(result)


    val treeNode = TreeNode(2147483647)
    treeNode.left = TreeNode(2147483647)
//    treeNode.right = TreeNode(2)
//    treeNode.right!!.left = TreeNode(3)
//    treeNode.right!!.right = TreeNode(1)
    val r = isValidBST(treeNode)
    assert(r)
}

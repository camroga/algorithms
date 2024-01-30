package binary_search_trees

fun inOrderTraverse(tree: bst, array: MutableList<Int>): List<Int> {
    if (tree.left != null) inOrderTraverse(tree.left!!, array)
    array.add(tree.value)
    if (tree.right != null) inOrderTraverse(tree.right!!, array)
    return array
}

fun preOrderTraverse(tree: bst, array: MutableList<Int>): List<Int> {
    array.add(tree.value)
    if (tree.left != null) preOrderTraverse(tree.left!!, array)
    if (tree.right != null) preOrderTraverse(tree.right!!, array)
    return array
}

fun postOrderTraverse(tree: bst, array: MutableList<Int>): List<Int> {
    if (tree.left != null) postOrderTraverse(tree.left!!, array)
    if (tree.right != null) postOrderTraverse(tree.right!!, array)
    array.add(tree.value)
    return array
}

fun main() {
    val root = bst(10)
    root.left = bst(5)
    root.left!!.left = bst(2)
    root.left!!.left!!.left = bst(1)
    root.left!!.right = bst(5)
    root.right = bst(15)
    root.right!!.right = bst(22)
    val tree = mutableListOf<Int>()
    inOrderTraverse(tree = root, array = tree)
    assert(tree == listOf(1, 2, 5, 5, 10, 15, 22))
    tree.clear()
    preOrderTraverse(tree = root, array = tree)
    assert(tree == listOf(10, 5, 2, 1, 5, 15, 22))
    tree.clear()
    postOrderTraverse(tree = root, array = tree)
    assert(tree == listOf(1, 2, 5, 5, 22, 15, 10))
}
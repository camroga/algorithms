package binary_search_trees

fun branchSums(root: BinaryTree): List<Int> {
    val branchList = mutableListOf<Int>()
    branchSumSeed(root, branchList, 0)
    return branchList
}

fun branchSumSeed(tree: BinaryTree, branchList: MutableList<Int>, currentValue: Int) {
    val total = currentValue + tree.value
    if (tree.left == null && tree.right == null) {
        branchList.add(total)
    }
    tree.left?.let { branchSumSeed(it, branchList, total) }
    tree.right?.let { branchSumSeed(it, branchList, total) }
}
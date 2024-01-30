package binary_search_trees

import kotlin.math.abs

/*{
"target": 4501,
"tree": {
    "nodes": [
    {"id": "100", "left": "5", "right": "502", "value": 100},
    {"id": "502", "left": "204", "right": "55000", "value": 502},
    {"id": "55000", "left": "1001", "right": null, "value": 55000},
    {"id": "1001", "left": null, "right": "4500", "value": 1001},
    {"id": "4500", "left": null, "right": null, "value": 4500},
    {"id": "204", "left": "203", "right": "205", "value": 204},

    {"id": "205", "left": null, "right": "207", "value": 205},
    {"id": "207", "left": "206", "right": "208", "value": 207},
    {"id": "208", "left": null, "right": null, "value": 208},
    {"id": "206", "left": null, "right": null, "value": 206},
    {"id": "203", "left": null, "right": null, "value": 203},
    {"id": "5", "left": "2", "right": "15", "value": 5},
    {"id": "15", "left": "5-2", "right": "22", "value": 15},
    {"id": "22", "left": null, "right": "57", "value": 22},
    {"id": "57", "left": null, "right": "60", "value": 57},
    {"id": "60", "left": null, "right": null, "value": 60},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "2", "left": "1", "right": "3", "value": 2},
    {"id": "3", "left": null, "right": null, "value": 3},
    {"id": "1", "left": "-51", "right": "1-2", "value": 1},
    {"id": "1-2", "left": null, "right": "1-3", "value": 1},
    {"id": "1-3", "left": null, "right": "1-4", "value": 1},
    {"id": "1-4", "left": null, "right": "1-5", "value": 1},
    {"id": "1-5", "left": null, "right": null, "value": 1},
    {"id": "-51", "left": "-403", "right": null, "value": -51},
    {"id": "-403", "left": null, "right": null, "value": -403}
    ],
    "root": "100"
}
    .apply {
        left = BST(value = 204)
        right = BST(value = 55000)
    }*/

fun main(args: Array<String>) {
    val root = bst(value = 100).apply {
        left = bst(value = 5).apply {

        }
        right = bst(value = 502).apply {
            left = bst(value = 204).apply {
                left = bst(value = 203)
                right = bst(value = 205)
            }
            right = bst(value = 55000).apply {
                left = bst(value = 1001).apply {
                    right = bst(value = 4500)
                }
            }
        }
    }
    print(findClosestValueInBst(root, 4501))
}

fun findClosestValueInBst(tree: bst, target: Int): Int {
    var res = tree.value
    tree.left?.let {
        val newValue = findClosestValueInBst(it, target)
        if (abs(target - newValue) < abs(target - res)) {
            res = newValue
        }
    }
    tree.right?.let {
        val newValue = findClosestValueInBst(it, target)
        if (abs(target - newValue) < abs(target - res)) {
            res = newValue
        }
    }
    return res
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

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
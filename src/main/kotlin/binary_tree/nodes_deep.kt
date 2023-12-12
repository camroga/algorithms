package binary_tree

import java.util.*


open class BinaryTree2(var value: Int) {
    var left: BinaryTree2? = null
    var right: BinaryTree2? = null
}

fun nodeDepths(root: BinaryTree2): Int {
    var sumNd = 0
    val queue: Queue<Pair<BinaryTree2, Int>> = LinkedList()
    queue.add(Pair(root, 0))
    while (queue.isNotEmpty()) {
        val ele: Pair<BinaryTree2, Int> = queue.poll()
        sumNd += ele.second
        if (ele.first.left != null) {
            queue.add(Pair(ele.first.left!!, ele.second + 1))
        }
        if (ele.first.right != null) {
            queue.add(Pair(ele.first.right!!, ele.second + 1))
        }
    }
    return sumNd
}

fun main() {
    val root = BinaryTree2(value = 1).apply {
        left = BinaryTree2(value = 2).apply {
            left = BinaryTree2(value = 4).apply {
                left = BinaryTree2(value = 8)
                right = BinaryTree2(value = 9)
            }
            right = BinaryTree2(value = 5).apply {
            }
        }
        right = BinaryTree2(value = 3).apply {
            left = BinaryTree2(value = 6).apply {
            }
            right = BinaryTree2(value = 7).apply {
            }
        }
    }
    print(nodeDepths(root))
}

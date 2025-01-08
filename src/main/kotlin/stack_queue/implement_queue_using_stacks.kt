package stack_queue

class MyQueue() {
    var root: Node? = null
    var tail: Node? = null

    fun push(x: Int) {
        val newNode = Node(x)
        if(root == null) {
            root = newNode
            tail = root
        } else {
            tail?.next = newNode
            tail = tail?.next
        }
    }

    fun pop(): Int {
        val num = root?.num ?: -1
        root = root?.next
        return num
    }

    fun peek(): Int {
        return root?.num ?: -1
    }

    fun empty(): Boolean {
        return root == null
    }

}

data class Node(var num: Int, var next: Node? = null)

fun main(args: Array<String>) {
    val obj = MyQueue()
    obj.push(1)
    obj.push(2)
    println(obj.peek())
    println(obj.pop())
    println(obj.empty())
}
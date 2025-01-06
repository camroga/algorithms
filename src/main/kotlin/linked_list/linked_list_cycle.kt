package linked_list

fun hasCycleOnePivot(head: ListNode?): Boolean {
    val elements = mutableSetOf<ListNode>()
    var pivot = head
    while (pivot != null) {
        if (elements.contains(pivot)) {
            return true
        }
        elements.add(pivot)
        pivot = pivot.next
    }
    return false
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    //example 3 -> 2 -> 0 -> -4 -> 3
    //in some point fast will be root = 3 and slow will be the tail = 3

    while (fast?.next != null) {
        // Move slow pointer by 1 step
        slow = slow?.next
        // Move fast pointer by 2 steps
        fast = fast.next?.next
        // If they meet, a cycle is detected
        if (slow == fast) {
            return true
        }
    }
    return false // If fast reaches the end, no cycle exists
}

fun main(args: Array<String>) {
    val root = ListNode(`val` = 1)
    println(hasCycle(root.apply {
        next = ListNode(`val` = 2).apply {
            next = root
        }
    }))
}
package linked_list

fun main(args: Array<String>) {
    val linkedList = LinkedList(value = 1).apply {
        next = LinkedList(value = 1).apply {
            next = LinkedList(value = 2).apply {
                next = LinkedList(value = 3)
            }
        }
    }
//    print(removeDuplicatesFromLinkedList(linkedList))
    print(middleNode(linkedList))
}

// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    var pivote = linkedList
    while (pivote.next != null) {
        if (pivote.value == pivote.next!!.value) {
            pivote.next = pivote.next!!.next
        } else {
            pivote = pivote.next!!
        }
    }
    return linkedList
}

fun middleNode(linkedList: LinkedList): LinkedList {
    if(linkedList.next == null) {
        return linkedList
    }
    var pivote: LinkedList? = linkedList
    var length = 1
    while(pivote?.next != null) {
        length += 1
        pivote = pivote.next
    }
    pivote = linkedList
    var i=0
    while(i < length/2) {
        pivote = pivote?.next
        i+=1
    }
    return pivote!!
}
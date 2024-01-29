package binary_search_trees


// Do not edit the class below except for
// the insert, contains, and remove methods.
// Feel free to add new properties and methods
// to the class.
open class BSTA(value: Int) {
    var value = value
    var left: BSTA? = null
    var right: BSTA? = null

    fun insert(value: Int): BSTA {
        if (value < this.value) {
            if (left == null) {
                this.left = BSTA(value = value)
                return this
            }
            left!!.insert(value)
        } else {
            if (right == null) {
                right = BSTA(value)
                return this
            }
            right!!.insert(value)
        }
        return this
    }

    fun contains(value: Int): Boolean {
        if (value == this.value) return true
        if (left != null && value < this.value) {
            return left?.contains(value)!!
        }
        if (right != null && value > this.value) {
            return right?.contains(value)!!
        }
        return false
    }

    fun remove(value: Int): BSTA {
        // does not exist the value
        if (!contains(value)) return this

        val father = findFather(value = value, father = null)
        if (father != null) {
            val child = if (father.left?.value == value) father.left else father.right
            if (hasNotChildren(child)) {
                // delete node with zero children
                if (father.left?.value == value) father.left = null else father.right = null
                return this
            }
            // has a child
            if (child?.left == null) {
                if (father.left?.value == value) father.left = child?.right
                else father.right = child?.right
                return this
            }
            if (child.right == null) {
                if (father.right?.value == value) father.right = child.left
                else father.left = child.left
                return this
            }
        } else {
            // element to delete is the root
            if (hasNotChildren(this)) {
                return this
            }
            // has a child
            if (left == null) {
                this.value = right!!.value
                this.left = right?.left
                this.right = right?.right
                return this
            }
            if (right == null) {
                this.value = left!!.value
                this.left = left?.left
                this.right = left?.right
                return this
            }
        }
        // has children
        val next = getNextSeed(value = value) ?: return this
        val nextFather = findFather(value = next.value, father = null)
        if (nextFather?.left?.value == next.value) nextFather.left = null else nextFather?.right = null
        this.value = next.value
        return this
    }

    private fun getNextSeed(value: Int): BSTA? {
        if (this.value >= value && this.left == null && this.right == null) return this

        if (this.left != null && this.left!!.value >= value) {
            return this.left?.getNextSeed(value)
        }
        if (this.right != null && this.right!!.value >= value) {
            return this.right?.getNextSeed(value)
        }
        return null
    }

    private fun hasNotChildren(child: BSTA?) = child?.left == null && child?.right == null

    private fun findFather(value: Int, father: BSTA?): BSTA? {
        if (value == this.right?.value) return right?.findFather(value, father = this)
        if (value == this.value) return father
        if (value > this.value) return right?.findFather(value, father = this)
        return left?.findFather(value, father = this)
    }
}


fun main(args: Array<String>) {
    val root = BSTA(10)
    root.left = BSTA(5)
    root.left!!.left = BSTA(2)
    root.left!!.left!!.left = BSTA(1)
    root.right = BSTA(15)
    root.right!!.left = BSTA(13)
    root.right!!.left!!.left = BSTA(12)
    root.right!!.left!!.right = BSTA(14)
    root.right!!.right = BSTA(22)
    root.remove(5)
}

/*fun main(args: Array<String>) {
    val root = BSTA(10)
    root.left = BSTA(5)
    root.left!!.left = BSTA(2)
    root.left!!.left!!.left = BSTA(1)
    root.left!!.right = BSTA(5)
    root.right = BSTA(15)
    root.right!!.left = BSTA(13)
    root.right!!.left!!.left = BSTA(12)
    root.right!!.left!!.right = BSTA(14)
    root.right!!.right = BSTA(22)

    root.remove(10)
    assert(root.contains(10))
    assert(root.contains(15))
}*/

/*
fun main(args: Array<String>) {
    val root = BSTA(10)
    root.left = BSTA(5)
    root.left!!.left = BSTA(2)
    root.left!!.left!!.left = BSTA(1)
    root.left!!.right = BSTA(5)
    root.right = BSTA(15)
    root.right!!.left = BSTA(13)
    root.right!!.left!!.right = BSTA(14)
    root.right!!.right = BSTA(22)

    root.insert(12)
    assert(root.right!!.left!!.left != null)
    assert(root.right!!.left!!.left!!.value == 12)

    root.remove(10)
    assert(!root.contains(10))
    assert(root.value == 12)

    assert(root.contains(15))
}*/

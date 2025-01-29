package graph

import java.util.*

class DirectedCycle(adj: List<List<Int>>) {
    var marked: MutableList<Boolean>
    var edgeTo: MutableList<Int>
    var cycle: ArrayDeque<Int>? = null  // vertices on a cycle
    var onStack: MutableList<Boolean> //vertices on recursive call

    init {
        val N = adj.size
        onStack = MutableList(N) { false }
        edgeTo = MutableList(N) { -1 }
        marked = MutableList(N) { false }
        (0 until N).forEach { v ->
            if (!marked[v]) dfs(v, adj)
        }
    }

    fun hasCycle(): Boolean {
        return cycle?.isNotEmpty() ?: false
    }

    private fun dfs(v: Int, G: List<List<Int>>) {
        onStack[v] = true
        marked[v] = true
        G[v].forEach { w ->
            if (hasCycle()) return
            else if (!marked[w]) {
                edgeTo[w] = v
                dfs(w, G)
            } else if (onStack[w]) {
                cycle = ArrayDeque()
                var x = v
                while (x != w) {
                    cycle?.push(x)
                    x = edgeTo[x]
                }
                cycle?.push(w)
                cycle?.push(v)
            }
        }
        onStack[v] = false
    }
}

fun cycleInGraph(edges: List<List<Int>>): Boolean {
    val DC = DirectedCycle(edges)
    return DC.hasCycle()
}

fun main(args: Array<String>) {
    val input = listOf(
        listOf(1, 3),
        listOf(2, 3, 4),
        listOf(0),
        listOf(),
        listOf(2, 5),
        listOf(),
    )
    val expected = true
    val output = cycleInGraph(input)
    assert(expected == output)
}

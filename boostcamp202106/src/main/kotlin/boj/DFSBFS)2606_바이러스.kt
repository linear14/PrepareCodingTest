package boj

import java.util.*

private var n = 0
private lateinit var adj: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

private fun main() {
    n = readLine()!!.toInt()
    adj = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)

    repeat(readLine()!!.toInt()) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            adj[it[0]].add(it[1])
            adj[it[1]].add(it[0])
        }
    }

    print(bfs())
}

private fun bfs(): Int {
    val q = LinkedList<Int>().apply {
        offer(1)
        visited[1] = true
    }

    var ans = 0
    while(q.isNotEmpty()) {
        val node = q.poll()
        adj[node].forEach {
            if(!visited[it]) {
                ans++
                q.offer(it)
                visited[it] = true
            }
        }
    }
    return ans
}
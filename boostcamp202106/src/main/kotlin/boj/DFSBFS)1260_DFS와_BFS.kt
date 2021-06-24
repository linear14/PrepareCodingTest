package boj

import java.util.*

private var n = 0
private var m = 0
private var v = 0
private lateinit var adj: Array<MutableList<Int>>   // 인접 리스트 구현
private lateinit var visited: BooleanArray

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.also {
        n = it[0]
        m = it[1]
        v = it[2]
    }

    adj = Array(n + 1) { mutableListOf() }
    repeat(m) {
        readLine()!!.split(" ").map { it.toInt() }.also {
            adj[it[0]].add(it[1])
            adj[it[1]].add(it[0])
        }
    }
    adj.forEach { it.sort() }

    init()
    dfs(v)
    println()
    init()
    bfs()
}

private fun dfs(node: Int) {
    print("$node ")
    visited[node] = true

    for(i in adj[node]) {
        if(!visited[i]) {
            dfs(i)
        }
    }
}

private fun bfs() {
    val q = LinkedList<Int>().apply {
        offer(v)
        visited[v] = true
    }

    while(q.isNotEmpty()) {
        val node = q.poll()

        for(i in adj[node]) {
            if(!visited[i]) {
                q.offer(i)
                visited[i] = true
            }
        }
        print("$node ")
    }
}

private fun init() {
    visited = BooleanArray(n + 1)
}
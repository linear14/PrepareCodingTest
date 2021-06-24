package boj

import java.util.*

private var s = 0
private var e = 0
private lateinit var visited: BooleanArray
private lateinit var q: LinkedList<IntArray>

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.also {
        s = it[0]
        e = it[1]
    }
    visited = BooleanArray(100001)
    bfs()
}

// intArray
// [0] pos [1] depth
private fun bfs() {
    q = LinkedList<IntArray>().apply {
        offer(intArrayOf(s, 0))
        visited[s] = true
    }
    while(q.isNotEmpty()) {
        val (cPos, depth) = q.poll().apply { get(0) to get(1) }
        if(cPos == e) {
            print(depth)
            return
        }

        goNextIfNotVisited(cPos - 1, depth)
        goNextIfNotVisited(cPos + 1, depth)
        goNextIfNotVisited(cPos * 2, depth)
    }
}

private fun goNextIfNotVisited(next: Int, depth: Int) {
    if(next in 0..100000 && !visited[next]) {
        visited[next] = true
        q.offer(intArrayOf(next, depth + 1))
    }
}
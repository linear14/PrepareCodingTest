package boj

import java.util.*

private var n = 0
private var m = 0
private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.also {
        n = it[0]
        m = it[1]
    }
    arr = Array(n + 2) { CharArray(m + 2) }
    visited = Array(n + 2) { BooleanArray(m + 2) }
    for(i in 1..n) {
        readLine()!!.forEachIndexed { index, value -> arr[i][index + 1] = value }
    }

    bfs()
}

private fun bfs() {
    val q = LinkedList<IntArray>().apply {
        offer(intArrayOf(1, 1, 1))
        visited[1][1] = true
    }

    while(q.isNotEmpty()) {
        val node = q.poll()

        for(i in 0..3) {
            val nRow = node[0] + dy[i]
            val nCol = node[1] + dx[i]
            if(nRow == n && nCol == m) {
                println(node[2] + 1)
                return
            }
            if(!visited[nRow][nCol] && arr[nRow][nCol] == '1') {
                q.offer(intArrayOf(nRow, nCol, node[2] + 1))
                visited[nRow][nCol] = true
            }
        }
    }
}
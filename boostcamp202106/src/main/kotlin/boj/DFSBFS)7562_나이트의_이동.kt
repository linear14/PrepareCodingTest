package boj

import java.util.*

private var n = 0
private lateinit var visited: Array<BooleanArray>
private val dx = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
private val dy = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

private fun main() {
    repeat(readLine()!!.toInt()) {
        n = readLine()!!.toInt()
        visited = Array(n) { BooleanArray(n) }

        val sPos = readLine()!!.split(" ").map { it.toInt() }
        val ePos = readLine()!!.split(" ").map { it.toInt() }

        bfs(sPos[0], sPos[1], ePos[0], ePos[1])
    }
}

// IntArray
// [0] row [1] col [2] depth
private fun bfs(sRow: Int, sCol: Int, eRow: Int, eCol: Int) {
    val q = LinkedList<IntArray>().apply {
        offer(intArrayOf(sRow, sCol, 0))
        visited[sRow][sCol] = true
    }

    while(q.isNotEmpty()) {
        val next = q.poll()

        if(next[0] == eRow && next[1] == eCol) {
            println(next[2])
            return
        }

        for(i in 0..7) {
            val nRow = next[0] + dy[i]
            val nCol = next[1] + dx[i]

            if(nRow in 0 until n && nCol in 0 until n && !visited[nRow][nCol]) {
                q.offer(intArrayOf(nRow, nCol, next[2] + 1))
                visited[nRow][nCol] = true
            }
        }
    }
}
package boj

import java.util.*

private var w = 0
private var h = 0
private val dy = arrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
private val dx = arrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

private fun main() {
    while(true) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            w = it[0]
            h = it[1]
        }
        if(w == 0 && h == 0) break

        arr = Array(h) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
        visited = Array(h) { BooleanArray(w) }

        var ans = 0
        for(i in 0 until h) {
            for(j in 0 until w) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j)
                    ans++
                }
            }
        }
        println(ans)
    }

}

private fun dfs(y: Int, x: Int) {
    visited[y][x] = true

    for(i in 0 until 8) {
        val ny = y + dy[i]
        val nx = x + dx[i]

        if(nx in 0 until w && ny in 0 until h && !visited[ny][nx]) {
            if(arr[ny][nx] == 1) {
                dfs(ny, nx)
            } else {
                visited[ny][nx] = true
            }
        }
    }
}

private fun bfs(y: Int, x: Int) {
    val q = LinkedList<Pair<Int, Int>>().apply {
        offer(Pair(x, y))
        visited[y][x] = true
    }

    while(q.isNotEmpty()) {
        val pos = q.poll()

        for(i in 0 until 8) {
            val ny = pos.second + dy[i]
            val nx = pos.first + dx[i]

            if(nx in 0 until w && ny in 0 until h && !visited[ny][nx] && arr[ny][nx] == 1) {
                q.offer(Pair(nx, ny))
                visited[ny][nx] = true
            }
        }
    }
}
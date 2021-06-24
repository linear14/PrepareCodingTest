package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private var m = 0
private var n = 0
private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine()!!.split(" ").map { it.toInt() }.also {
            m = it[0]
            n = it[1]

            arr = Array(n + 2) { IntArray(m + 2) }
            visited = Array(n + 2) { BooleanArray(m + 2) }
            repeat(it[2]) {
                readLine()!!.split(" ").map { it.toInt() }.apply {
                    arr[get(1) + 1][get(0) + 1] = 1
                }
            }
        }

        var ans = 0
        for(i in 1..n) {
            for(j in 1..m) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    ans++
                    dfs(i, j)
                }
            }
        }
        bw.write("$ans\n")
    }
    bw.flush()
    bw.close()
}

private fun dfs(row: Int, col: Int) {
    visited[row][col] = true

    for(i in 0..3) {
        val nRow = row + dy[i]
        val nCol = col + dx[i]

        if(!visited[nRow][nCol] && arr[nRow][nCol] == 1) {
            dfs(nRow, nCol)
        }
    }
}
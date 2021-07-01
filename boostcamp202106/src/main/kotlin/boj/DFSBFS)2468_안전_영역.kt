package boj

import java.util.*

private var n = 0
private lateinit var arr: Array<IntArray>
private lateinit var isWaterOrChecked: Array<BooleanArray>

private val dy = arrayOf(-1, 1, 0, 0)
private val dx = arrayOf(0, 0, -1, 1)

private fun main() {
    n = readLine()!!.toInt()
    arr = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    var max = Int.MIN_VALUE
    for(h in 0..100) {
        isWaterOrChecked = Array(n) { BooleanArray(n) }

        for(row in 0 until n) {
            for(col in 0 until n) {
                if(arr[row][col] <= h) {
                    isWaterOrChecked[row][col] = true
                }
            }
        }

        var cnt = 0
        for(row in 0 until n) {
            for(col in 0 until n) {
                if(!isWaterOrChecked[row][col]) {
                    bfs(row, col)
                    cnt++
                }
            }
        }

        if(cnt > max) {
            max = cnt
        }

        // cnt가 0이라는 말은, 다 잠겨버렸다는 뜻이므로 더 이상 체크 할 필요가 없음
        if(cnt == 0) {
            break
        }
    }

    print(max)
}

private fun bfs(row: Int, col: Int) {
    val q = LinkedList<Pair<Int, Int>>().apply {
        isWaterOrChecked[row][col] = true
        offer(Pair(row, col))
    }

    while(q.isNotEmpty()) {
        val pos = q.poll()

        for(i in 0..3) {
            val nRow = pos.first + dy[i]
            val nCol = pos.second + dx[i]

            if(nRow in 0 until n && nCol in 0 until n && !isWaterOrChecked[nRow][nCol]) {
                isWaterOrChecked[nRow][nCol] = true
                q.offer(Pair(nRow, nCol))
            }
        }
    }
}
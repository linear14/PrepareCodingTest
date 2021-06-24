package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()
    repeat(t) {
        val (n, d) = readLine()!!.split(" ").map { it.toInt() }
        val arr = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
        val originalArr = Array(n) { IntArray(n) }
        for(i in 0 until n) {
            for(j in 0 until n) {
                originalArr[i][j] = arr[i][j]
            }
        }

        val times = ((d + 360) % 360) / 45
        val dx = arrayOf(1, 1, 0, 0, -1, -1, 0, 0)
        val dy = arrayOf(0, 0, 1, 1, 0, 0, -1, -1)

        var dRow = 0
        var dCol = 0
        var posStart = 0
        var posEnd = times

        // times(반복 횟수)에 따라 dRow, dCol 실질적인 초기화
        repeat(times) {
            dRow += dy[it]
            dCol += dx[it]
        }

        // offset: 중앙으로부터 얼마나 떨어졌는지, 간격
        for(offset in 1..(n/2)) {
            // currentRow, currentCol
            var cRow = (n/2 - offset)
            var cCol = (n/2 - offset)

            // println("========= 중앙으로부터 $offset 떨어진 곳 =========")

            for(i in 0 until 8) {
                // times만큼 돌렸을 때 이동할 Position
                val newRow = cRow + (dRow * offset)
                val newCol = cCol + (dCol * offset)

                // Test
                // println("($cRow, $cCol) -> ($newRow, $newCol) [위치변화: ($dRow, $dCol)]")

                // arr에 넣어주기
                arr[newRow][newCol] = originalArr[cRow][cCol]

                // 다음 Position으로 이동
                cRow += (dy[i] * offset)
                cCol += (dx[i] * offset)
                dRow += (dy[posEnd % 8] - dy[posStart % 8])
                dCol += (dx[posEnd % 8] - dx[posStart % 8])
                posStart++
                posEnd++
            }
        }

        for(i in 0 until n) {
            for(j in 0 until n) {
                bw.write("${arr[i][j]} ")
            }
            bw.write("\n")
        }
    }
    bw.flush()
    bw.close()
}

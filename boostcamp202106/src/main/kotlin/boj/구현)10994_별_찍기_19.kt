package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private var n = 0
private lateinit var arr: Array<CharArray>

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    n = readLine()!!.toInt()
    arr = Array(4 * n  - 3) { CharArray(4 * n - 3) { ' ' } }

    for(level in 1..n) {
        makeStar(level)
    }

    for(i in arr.indices) {
        for(j in arr.indices) {
            bw.write("${arr[i][j]}")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

private fun makeStar(level: Int) {
    val mid = 2 * n - 2

    if(level == 1) {
        arr[mid][mid] = '*'
        return
    }

    val start = mid - 2 * (level - 1)
    val end = mid + 2 * (level - 1)

    for(i in start..end) {
        arr[start][i] = '*'
        arr[end][i] = '*'
        arr[i][start] = '*'
        arr[i][end] = '*'
    }
}
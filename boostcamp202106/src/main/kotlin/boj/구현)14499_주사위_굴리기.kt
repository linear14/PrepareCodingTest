package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private data class State(val top: Int, val front: Int, val side: Int)

private var n = 0
private var m = 0
private var x = 0
private var y = 0

private lateinit var board: Array<IntArray>
private lateinit var dice: IntArray
private lateinit var state: State

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    dice = IntArray(7)
    state = State(1, 5, 3)

    readLine()!!.split(" ").map { it.toInt() }.let {
        n = it[0]
        m = it[1]
        y = it[2]
        x = it[3]
    }
    board = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    // 동 서 북 남
    readLine()!!.split(" ").map { it.toInt() }.forEach { cmd ->
        when(cmd) {
            1 -> {
                if(isPossibleMove(x + 1, y)) {
                    x += 1
                    state = state.copy(top = 7 - state.side, side = state.top)
                    workAndPrint(bw)
                }
            }
            2 -> {
                if(isPossibleMove(x - 1, y)) {
                    x -= 1
                    state = state.copy(top = state.side, side = 7 - state.top)
                    workAndPrint(bw)
                }
            }
            3 -> {
                if(isPossibleMove(x, y - 1)) {
                    y -= 1
                    state = state.copy(front = 7 - state.top, top = state.front)
                    workAndPrint(bw)
                }
            }
            4 -> {
                if(isPossibleMove(x, y + 1)) {
                    y += 1
                    state = state.copy(front = state.top, top = 7 - state.front)
                    workAndPrint(bw)
                }
            }
        }
    }

    bw.flush()
    bw.close()
}

private fun isPossibleMove(nx: Int, ny: Int): Boolean = (nx in 0 until m) && (ny in 0 until n)

private fun workAndPrint(bw: BufferedWriter) {
    if(board[y][x] == 0) {
        board[y][x] = dice[7 - state.top]
    } else {
        dice[7 - state.top] = board[y][x]
        board[y][x] = 0
    }
    bw.write("${dice[state.top]}\n")
}


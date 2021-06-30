package boj

import java.util.*

private var n = 0
private var k = 0
private lateinit var arr: Array<IntArray>   // 0 빈칸, 1 뱀, 2 사과
private var dir = 0
private val dy = arrayOf(0, 1, 0, -1)
private val dx = arrayOf(1, 0, -1, 0)

private fun main() {
    var (cy, cx) = 0 to 0
    n = readLine()!!.toInt()
    k = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }
    arr[cy][cx] = 1

    repeat(k) {
        readLine()!!.split(" ").map { it.toInt() }.also { arr[it[0] - 1][it[1] - 1] = 2 }
    }

    val q = LinkedList<Pair<Int, Int>>().apply { offer(Pair(cy, cx)) }
    val l = readLine()!!.toInt()
    val actions = Array(l) { readLine()!!.split(" ") }
    var sec = 0
    var actionPos = 0

    while(true) {
        val ny = cy + dy[dir]
        val nx = cx + dx[dir]

        if(isCollideWithWall(ny, nx) || isCollideWithSnake(ny, nx)) {
            print(sec + 1)
            return
        }

        // 사과가 있는지 없는지에 따라 Queue를 처리하는 로직
        val isNextApple = isNextApple(ny, nx)
        q.offer(Pair(ny, nx))
        arr[ny][nx] = 1

        if(!isNextApple) {
            val pos = q.poll()
            arr[pos.first][pos.second] = 0
        }

        if(actionPos < l && actions[actionPos][0].toInt() == sec + 1) {
            when(actions[actionPos][1]) {
                "D" -> {
                    dir = (dir + 1) % 4
                }
                "L" -> {
                    dir = (dir + 3) % 4
                }
            }
            actionPos++
        }

        cy = ny
        cx = nx
        sec++
    }
}

private fun isNextApple(ny: Int, nx: Int): Boolean =
        arr[ny][nx] == 2

private fun isCollideWithWall(ny: Int, nx: Int): Boolean {
    if (ny !in 0 until n || nx !in 0 until n) {
        return true
    }
    return false
}

private fun isCollideWithSnake(ny: Int, nx: Int): Boolean {
    if(arr[ny][nx] == 1) {
        return true
    }
    return false
}

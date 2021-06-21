package boj

private var n: Int = 0
private lateinit var arr: Array<IntArray>
private lateinit var room: Array<IntArray>
private lateinit var map: MutableMap<Int, IntArray>
private val dx = arrayOf(1, -1, 0, 0)
private val dy = arrayOf(0, 0, 1, -1)

// 행,열, 인접하는 곳에 존재하는 좋아하는 학생 수, 인접 영역의 비어있는 칸 수
private data class Area(val row: Int, val col: Int, val cntNearFavorite: Int, val cntNearEmpty: Int)

private fun main() {
    n = readLine()!!.toInt()
    arr = Array(n * n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    map = mutableMapOf()
    for(i in 0 until (n*n)) {
        val student = arr[i][0]
        val list = arr[i].toMutableList()
        list.removeAt(0)
        map[student] = list.toIntArray()
    }
    room = Array(n) { IntArray(n) }

    for (order in 0 until (n * n)) {
        val currentStudent = arr[order][0]
        val candidateAreas = mutableListOf<Area>()
        for (row in 0 until n) {
            for (col in 0 until n) {
                if (room[row][col] == 0) {
                    // 해당 칸 인접 영역에 좋아하는 사람 수, 비어있는 칸 수 세기
                    var cntFavorites = 0
                    var cntEmpties = 0

                    for (i in 0..3) {
                        val newRow = row + dy[i]
                        val newCol = col + dx[i]
                        if (newRow in 0 until n && newCol in 0 until n) {
                            if (room[newRow][newCol] in map[currentStudent]!!) {
                                cntFavorites++
                            }
                            if (room[newRow][newCol] == 0) {
                                cntEmpties++
                            }
                        }
                    }
                    candidateAreas.add(Area(row, col, cntFavorites, cntEmpties))
                }
            }
        }

        val sorted = candidateAreas
            .sortedBy { it.col }
            .sortedBy { it.row }
            .sortedByDescending { it.cntNearEmpty }
            .sortedByDescending { it.cntNearFavorite }

        room[sorted[0].row][sorted[0].col] = arr[order][0]
    }

    var ans = 0
    for(row in 0 until n) {
        for(col in 0 until n) {
            val currentStudent = room[row][col]

            var cnt = 0
            for(i in 0..3) {
                val newRow = row + dy[i]
                val newCol = col + dx[i]

                if (newRow in 0 until n && newCol in 0 until n) {
                    if (room[newRow][newCol] in map[currentStudent]!!) {
                        cnt++
                    }
                }
            }
            ans += when(cnt) {
                1 -> 1
                2 -> 10
                3 -> 100
                4 -> 1000
                else -> 0
            }

        }
    }

    /*for(i in 0 until n) {
        for(j in 0 until n) {
            print("${room[i][j]} ")
        }
        println()
    }*/

    print(ans)
}

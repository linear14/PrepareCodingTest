package boj

private fun main() {
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    val n = readLine()!!.toInt()
    val target = readLine()!!.toInt()
    val arr = Array(n) { IntArray(n) }

    // 0: 아래로 1: 오른쪽으로 2: 위로 3: 왼쪽으로
    var currentType = 0
    var next = n * n
    var row = 0
    var col = 0

    var tempRow = 0
    var tempCol = 0

    while(next > 0) {
        arr[row][col] = next

        if(next == target) {
            tempRow = row + 1
            tempCol = col + 1
        }

        val tempNextRow = row + dy[currentType]
        val tempNextCol = col + dx[currentType]

        if(tempNextRow !in 0 until n || tempNextCol !in 0 until n || arr[tempNextRow][tempNextCol] != 0) {
            if(currentType == 3) {
                currentType = 0
            } else {
                currentType++
            }
        }

        row += dy[currentType]
        col += dx[currentType]
        next--
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            print("${arr[i][j]} ")
        }
        println()
    }
    println("$tempRow $tempCol")

}
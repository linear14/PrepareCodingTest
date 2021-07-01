package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private var n = 0
private lateinit var adj: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    n = readLine()!!.toInt()
    adj = Array(n) { mutableListOf() }

    repeat(n) { i ->
        readLine()!!.split(" ").map { it.toInt() }.forEachIndexed { j, value ->
            if(value == 1) {
                adj[i].add(j)
            }
        }
    }

    for(i in 0 until n) {
        visited = BooleanArray(n)
        dfs(i)

        visited.forEach { visit ->
            when(visit) {
                true -> bw.write("1 ")
                false -> bw.write("0 ")
            }
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

private fun dfs(num: Int) {
    adj[num].forEach {
        if(!visited[it]) {
            visited[it] = true
            dfs(it)
        }
    }
}
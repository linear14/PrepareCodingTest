package boj

private var n = 0   // 정점의 수
private var m = 0   // 간선의 수
private lateinit var adj: Array<MutableList<Int>>
private lateinit var visited: BooleanArray

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.also {
        n = it[0]
        m = it[1]
    }
    adj = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)
    repeat(m) {
        readLine()!!.split(" ").map { it.toInt() }.apply {
            adj[get(0)].add(get(1))
            adj[get(1)].add(get(0))
        }
    }

    var ans = 0
    for(i in 1..n) {
        if(!visited[i]) {
            ans++
            dfs(i)
        }
    }
    print(ans)
}

private fun dfs(node: Int) {
    visited[node] = true
    for(i in adj[node]) {
        if(!visited[i]) {
            dfs(i)
        }
    }
}
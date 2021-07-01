package boj

private var v = 0
private var e = 0
private var node = 0

// [Pair.first: 도착지점] [Pair.second: 가중치]
private lateinit var adj: Array<MutableList<Pair<Int, Int>>>
private lateinit var distance: IntArray
private lateinit var visited: BooleanArray

private fun main() {
    readLine()!!.split(" ").map { it.toInt() }.let {
        v = it[0]
        e = it[1]
    }
    node = readLine()!!.toInt() - 1

    adj = Array(v) { mutableListOf() }
    repeat(e) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            adj[it[0] - 1].add(Pair(it[1] - 1, it[2]))
        }
    }
    distance = IntArray(v) { Int.MAX_VALUE }
    visited = BooleanArray(v)

    dijkstra()

    distance.forEach { if(it == Int.MAX_VALUE) println("INF") else println(it) }
}

private fun dijkstra() {
    distance[node] = 0
    visited[node] = true

    while(true) {
        adj[node].forEach {
            val (next, d) = it.first to it.second

            if(!visited[next]) {
                val nDistance = distance[node] + d

                if(distance[node] == Int.MAX_VALUE) {
                    distance[next] = nDistance
                } else {
                    if(distance[next] > nDistance) {
                        distance[next] = nDistance
                    }
                }
            }
        }

        // 최소값 찾기
        var min = Int.MAX_VALUE
        var minIdx = -1
        for(i in 0 until v) {
            if(!visited[i] && distance[i] != Int.MAX_VALUE) {
                if(distance[i] < min) {
                    min = distance[i]
                    minIdx = i
                }
            }
        }

        if(minIdx == -1) {
            break
        } else {
            visited[minIdx] = true
            node = minIdx
        }
    }
}
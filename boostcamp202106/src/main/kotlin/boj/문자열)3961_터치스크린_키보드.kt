package boj

import kotlin.math.abs

private fun main() {
    val map = mutableMapOf<Char, Pair<Int, Int>>()
    arrayOf("qwertyuiop", "asdfghjkl", "zxcvbnm").forEachIndexed { i, line ->
        line.forEachIndexed { j, value -> map[value] = Pair(i, j) }
    }

    repeat(readLine()!!.toInt()) {
        val (input, l) = readLine()!!.split(" ")
        val arr = Array(l.toInt()) { readLine()!! }
        val dMap = arr.groupBy {
            var d = 0
            for(i in input.indices) {
                d += abs(map[input[i]]!!.first - map[it[i]]!!.first)
                d += abs(map[input[i]]!!.second - map[it[i]]!!.second)
            }
            d
        }.toMutableMap()

        dMap.keys.sorted().forEach { distance ->
            if(dMap.containsKey(distance)) {
                dMap[distance]!!.sorted().forEach { value ->
                    println("$value $distance")
                }
            }
        }
    }
}

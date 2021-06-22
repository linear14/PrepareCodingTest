package boj

private fun main() {
    val n = readLine()!!.toInt()
    val map = mutableMapOf<Int, Int>()
    var ans = 0

    repeat(n) {
        val (cow, road) = readLine()!!.split(" ").map { it.toInt() }
        if(map.contains(cow)) {
            val currentRoad = map[cow]
            if(road != currentRoad) {
                map[cow] = road
                ans++
            }
        } else {
            map[cow] = road
        }
    }

    println(ans)
}
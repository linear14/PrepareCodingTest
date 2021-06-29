package boj

// map : name<->index
private fun main() {
    val n = readLine()!!.toInt()
    val map = mutableMapOf<String, Int>()
    readLine()!!.split(" ").forEachIndexed { index, name -> map[name] = index }

    var ans = 0
    val ansList = readLine()!!.split(" ")
    for(i in 0 until n) {
        val current = map[ansList[i]]
        for(j in i + 1 until n) {
            if(map.containsKey(ansList[i]) && current!! < map[ansList[j]]!!) {
               ans++
            }
        }
    }

    println("$ans/${n * (n-1) / 2}")
}
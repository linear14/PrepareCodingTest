package boj

private var k: Int = 0
private lateinit var arr: IntArray
private lateinit var ans: Array<MutableList<Int>>

private fun main() {
    k = readLine()!!.toInt()
    arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    ans = Array(k) { mutableListOf() }

    divide(0, arr.size - 1, 0)

    for(elements in ans) {
        for(element in elements) {
            print("$element ")
        }
        println()
    }
}

private fun divide(start: Int, end: Int, level: Int) {
    if(level < k) {
        val mid = (start + end) / 2
        ans[level].add(arr[mid])
        divide(start, mid - 1, level + 1)
        divide(mid + 1, end, level + 1)
    }
}


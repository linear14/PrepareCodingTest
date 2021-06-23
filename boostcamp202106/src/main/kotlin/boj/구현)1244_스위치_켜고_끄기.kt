package boj

private fun main() {
    val n = readLine()!!.toInt()
    val switches = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val students = Array(readLine()!!.toInt()) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    students.forEach {
        var num = it[1]
        when(it[0]) {
            1 -> {
                while(num <= n) {
                    switches[num - 1] = if(switches[num - 1] == 0) 1 else 0
                    num += it[1]
                }
            }
            2 -> {
                var left = num - 1
                var right = num - 1

                while(left >= 0 && right < n && switches[left] == switches[right]) {
                    if(left == right) {
                        switches[left] = if(switches[left] == 0) 1 else 0
                    } else {
                        switches[left] = if(switches[left] == 0) 1 else 0
                        switches[right] = if(switches[right] == 0) 1 else 0
                    }
                    left--
                    right++
                }
            }
        }
    }

    switches.forEachIndexed { i, value ->
        print("$value ")
        if((i + 1) % 20 == 0) println()
    }

}
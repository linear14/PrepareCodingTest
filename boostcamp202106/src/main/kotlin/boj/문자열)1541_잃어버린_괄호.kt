package boj

import java.util.*

private fun main() {
    var ans = 0
    val expressions = readLine()!!.split("-")

    for((index, exp) in expressions.withIndex()) {
        exp.split("+").forEachIndexed { i, num ->
            if(index == 0) {
                ans += num.toInt()
            } else {
                ans -= num.toInt()
            }
        }
    }
    print(ans)
}
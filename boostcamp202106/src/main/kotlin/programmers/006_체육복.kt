package programmers

import java.util.*

class Solution6 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val remain = IntArray(n) { 1 }
        lost.forEach { remain[it-1]-- }
        reserve.forEach { remain[it-1]++ }

        remain.forEachIndexed { i, cnt ->
            if(cnt == 2) {
                when(i) {
                    0 -> {
                        if(remain[i + 1] == 0) {
                            remain[i + 1]++
                        }
                    }
                    n-1 -> {
                        if(remain[i - 1] == 0) {
                            remain[i - 1]++
                        }
                    }
                    else -> {
                        if(remain[i + 1] == 0) {
                            remain[i + 1]++
                        } else if(remain[i - 1] == 0) {
                            remain[i - 1]++
                        }
                    }
                }
            }
        }

        return remain.filter { it > 0 }.size
    }
}
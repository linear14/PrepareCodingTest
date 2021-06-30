package programmers

import java.util.*

class Solution3 {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var ans = 0
        absolutes.forEachIndexed { i, n ->
            ans += (n * if(signs[i]) 1 else -1)
        }
        return ans
    }
}
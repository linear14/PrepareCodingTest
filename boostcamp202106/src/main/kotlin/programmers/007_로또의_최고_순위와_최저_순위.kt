package programmers

import java.util.*

class Solution7 {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {

        val notZero = lottos.filter { it > 0 }
        val zeroCnt = 6 - notZero.size
        val correctCnt = notZero.filter { it in winNums }.size
        val ifCnt = zeroCnt + correctCnt

        return intArrayOf(getRank(ifCnt), getRank(correctCnt))
    }

    fun getRank(cnt: Int): Int {
        return when(cnt) {
            0 -> 6
            else -> 7 - cnt
        }
    }
}
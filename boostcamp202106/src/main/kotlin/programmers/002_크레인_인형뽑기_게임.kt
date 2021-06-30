package programmers

import java.util.*

class Solution2 {
    val bucket = Stack<Int>()

    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var ans = 0
        val size = board.size

        // 각 열마다 남아있는 인형의 갯수 세기
        val remains = IntArray(size)
        for((level, line) in board.withIndex()) {
            for((pos, dollIdx) in line.withIndex()) {
                if(dollIdx != 0 && remains[pos] == 0) {
                    remains[pos] = size - level
                }
            }
        }

        // moves 원소 하나씩 꺼내면서, bucket에 넣어주기
        for(pos in moves) {
            if(remains[pos - 1] > 0) {
                val picked = board[size - remains[pos - 1]][pos - 1]
                remains[pos - 1]--

                // bucket에서 인형이 터지는지 판단하기
                if(bucket.isNotEmpty() && bucket.peek() == picked) {
                    bucket.pop()
                    ans += 2
                } else {
                    bucket.push(picked)
                }
            }
        }

        return ans
    }
}
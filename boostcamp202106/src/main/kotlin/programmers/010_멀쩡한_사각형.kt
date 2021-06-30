package programmers

class Solution10 {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = w.toLong() * h

        // 1. 최대 공약수 구하기
        val gcd = makeGCD(w, h)

        // 2. w와 H를 각각 최대공약수와 나누어서 작은 뭉탱이 단위 만들기
        val unitW = w / gcd
        val unitH = h / gcd

        // 3. 작은 뭉탱이에서 선이 지나가는 갯수 구하기
        val unitPassCnt = unitH + (unitW - 1)

        // 4. 전체 칸수에서 [(3)에서 구한 값 * 최대 공약수] 빼주면 정답
        return answer - (unitPassCnt * gcd)
    }

    fun makeGCD(i1: Int, i2: Int): Int {
        var a = i1
        var b = i2

        while(b != 0) {
            val mod = a % b
            a = b
            b = mod
        }

        return a
    }
}
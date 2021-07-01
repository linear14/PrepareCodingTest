package programmers

import java.util.*

class Solution12 {
    fun solution(p: String) = makeCorrectStr(p)

    fun makeCorrectStr(str: String): String {
        if(str == "") return str

        val (u, v) = seperate(str).also { it[0] to it[1] }

        if(isCorrectStr(u)) {
            return u + makeCorrectStr(v)
        } else {
            var temp = "(" + makeCorrectStr(v) + ")"
            u.substring(1, u.length - 1).forEach {
                temp += if(it == '(') ")" else "("
            }
            return temp
        }
    }

    fun seperate(str: String): Array<String> {
        var leftCnt = 0
        var rightCnt = 0

        for(i in 0 until str.length) {
            if(str[i] == '(') {
                leftCnt++
            } else {
                rightCnt++
            }

            if(leftCnt == rightCnt) {
                break
            }
        }

        return arrayOf(str.substring(0, leftCnt + rightCnt), str.substring(leftCnt + rightCnt, str.length))
    }

    fun isCorrectStr(str: String): Boolean {
        val s = Stack<Char>()
        str.forEach {
            if(it == '(') {
                if(s.isNotEmpty() && s.peek() == ')') { return false }
                s.push(it)
            } else {
                if(s.isEmpty()) { return false }
                s.pop()
            }
        }
        return true
    }
}
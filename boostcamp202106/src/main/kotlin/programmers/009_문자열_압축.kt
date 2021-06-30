package programmers

class Solution9 {
    fun solution(s: String): Int {
        if(s.length == 1) {
            return 1
        }

        var minLength = Int.MAX_VALUE

        for(len in 1 .. s.length / 2) {
            // println("길이 : $len")
            var ans = 0
            var stack = 1
            var pre = ""
            for(i in 0 until s.length step len) {
                // println("$i 번째 뭉탱이 (${s.length - i}) : ")
                // 글자가 딱 떨어지지 않을 때
                if(i + len > s.length) {
                    // println("[글자수가 떨어지지 않음(남은 글자수: ${s.length - i})] - pre: $pre, stack: $stack, getLength(): ${getLength(stack)}")
                    ans += (s.length - i) + len + getLength(stack)

                } else {
                    // 처음 - 첫 묶음을 기준으로 정함
                    if(i == 0 && i != s.length - len) {
                        pre = s.substring(0, len)
                        continue
                    }

                    // 이전것과 비교하여 같으면? -> 다음으로 넘어가야됨 (stack + 1)
                    if(pre == s.substring(i, i + len)) {
                        stack++
                    } else {
                        // 다르면? -> 여태까지 모아놨던 것들을 출력하고, 기준값 변경, stack 초기화
                        // println("[여태 모아놨던 것 출력] - pre: $pre, stack: $stack, getLength(): ${getLength(stack)}")
                        ans += (len + getLength(stack))

                        pre = s.substring(i, i + len)
                        stack = 1
                    }

                    // 마지막 묶음 처리
                    if(i == s.length - len) {
                        // println("[마지막 뭉탱이 처리] - pre: $pre, stack: $stack, getLength(): ${getLength(stack)}")
                        ans += (len + getLength(stack))
                    }
                }

            }

            if(minLength > ans) {
                // println("ans: $ans")
                minLength = ans
            }
            // println()
        }

        return minLength
    }

    fun getLength(repeatCount: Int) =
            when(repeatCount) {
                1 -> 0
                else -> repeatCount.toString().length
            }
}
package boj

/*private lateinit var up: CharArray
private lateinit var down: CharArray*/

private fun main() {
    val (k, n) = readLine()!!.toInt() to readLine()!!.toInt()
    var blankIdx = 0
    val up = CharArray(k) { 'A' + it }
    val down = readLine()!!.toCharArray()
    val ans = CharArray(k - 1) { '*' }

    val cmds = Array(n) {
        val cmd = readLine()!!.toCharArray()
        if(cmd[0] == '?') { blankIdx = it }
        cmd
    }

    // 위에서부터 한 줄씩 내려오면서, '-' 문자를 찾는다.
    // 해당하는 '-'의 인덱스가 k 라면, 원래 배열의 [k <-> k + 1]번째 원소를 swap.
    for(i in 0 until blankIdx) {
        val cmd = cmds[i]
        cmd.forEachIndexed { idx, value ->
            if(value == '-') {
                swap(idx, idx + 1, up)
            }
        }
    }

    // 아래서부터 한 줄씩 올라가면서, '-' 문자를 찾는다.
    // 해당하는 '-'의 인덱스가 k 라면, 결과 배열의 [k <-> k + 1]번째 원소를 swap.
    for(i in n - 1 downTo blankIdx + 1) {
        val cmd = cmds[i]
        cmd.forEachIndexed { idx, value ->
            if(value == '-') {
                swap(idx, idx + 1, down)
            }
        }
    }

    /*
        원래 배열 A, 결과 배열 B의 i번째 원소간 비교를 진행한다. (i != 마지막일 경우에만)

        if(A[i] == B[i]) {
            그대로 냅두기
        } else {
            if(A[i] == B[i + 1] && A[i + 1] == B[i]) {
                ans[i] = '-'
            } else {
                // 이전꺼에 줄이 쳐져있으면 이상해도 상관 없으니깐
                if(ans[i - 1] != '-') {
                    xxxx 출력 후 return
                }
            }
        }

     */

    for(i in 0 until k - 1) {
        if(up[i] != down[i]) {
            if(up[i] == down[i + 1] && up[i + 1] == down[i]) {
                ans[i] = '-'
            } else {
                if(i == 0 || ans[i - 1] != '-') {
                    for(j in ans.indices) {
                        ans[j] = 'x'
                    }
                    break
                }
            }
        }
    }

    ans.forEach { print(it) }
}

private fun swap(i: Int, j: Int, arr: CharArray) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
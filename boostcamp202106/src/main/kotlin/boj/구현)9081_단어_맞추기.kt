package boj

// 가장 마지막 인덱스부터 하나씩 줄여나가면서 값이 증가함을 확인
// 이 때, 방문한 문자들을 낮은 순서대로 정렬하는 또 다른 배열을 만들어둠

// 만약, 값의 증가가 멈췄다면?
// 그 때의 인덱스에 해당하는 위치에, 그 값보다 큰 숫자이면서 가장 작은 수를 set 함
// 그 인덱스에 해당됐던 숫자는 정렬되어 있는 배열의 적절한 위치에 투입됨

// 최종적으로 정렬된 임시 배열의 모든 원소를 순서대로 원래 배열에 설정하면 끝

private fun main() {
    repeat(readLine()!!.toInt()) {
        val chars = readLine()!!.toCharArray()
        val sortedList = mutableListOf<Char>().apply { add(chars[chars.size - 1]) }

        for(i in chars.size - 1 downTo 0) {
            if(i == 0) {
                chars.forEach { print(it) }
                break
            }
            sortedList.add(chars[i - 1])
            sortedList.sort()

            if(chars[i] > chars[i - 1]) {
                var swapCharIdx = 0
                for((idx, num) in sortedList.withIndex()) {
                    if(num > chars[i - 1]) {
                        swapCharIdx = idx
                        break
                    }
                }
                chars[i - 1] = sortedList[swapCharIdx]
                sortedList.removeAt(swapCharIdx)

                for(j in 0 until i) {
                    print(chars[j])
                }
                sortedList.forEach { print(it) }
                break
            }
        }

        println()
    }
}

package study.sort

class ShellSort(val arr: IntArray) {

    fun sortAsc(): IntArray {
        var gap = arr.size / 2
        while(gap > 0) {
            // gap은 홀수인게 좋다고 합니다.
            if(gap % 2 == 0) {
                gap++
            }

            for(i in 0 until gap) {
                insertionSortAsc(i, gap)
            }

            // 다 끝나면
            gap /= 2
        }
        return arr
    }

    private fun insertionSortAsc(start: Int, gap: Int) {
        for(keyIndex in (start + gap) until arr.size step gap) {
            val key = arr[keyIndex]
            for(next in (keyIndex - gap) downTo 0 step gap) {
                if(arr[next] > key) {
                    arr[next + gap] = arr[next]
                    arr[next] = key
                } else {
                    break
                }
            }
        }
    }
}
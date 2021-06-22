package study.sort

/*
    선택정렬 (오름차순을 예시로)
    배열의 원소 중 가장 작은 값을 선택하여,
    앞에서부터 배치하는 방식
 */

class SelectionSort(val arr: IntArray) {

    fun sortAsc(): IntArray {
        for(i in arr.indices) {
            var minIndex = i
            for(j in (i + 1) until arr.size) {
                if(arr[j] <= arr[minIndex]) {
                    minIndex = j
                }
            }
            swap(i, minIndex)
        }
        return arr
    }

    private fun swap(i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}


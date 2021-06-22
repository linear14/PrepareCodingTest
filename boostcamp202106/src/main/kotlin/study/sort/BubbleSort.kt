package study.sort

/*
    버블정렬 (오름차순 기준)
    이웃한 두 원소끼리를 비교해서, 더 큰 원소를 오른쪽으로 보내는 방식
 */

class BubbleSort(val arr: IntArray) {

    fun sortAsc(): IntArray {
        for(last in (arr.size - 1) downTo 0) {
            for(i in 0 until last) {
                if(arr[i] > arr[i+1]) {
                    swap(i, i+1)
                }
            }
        }
        return arr
    }

    private fun swap(i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
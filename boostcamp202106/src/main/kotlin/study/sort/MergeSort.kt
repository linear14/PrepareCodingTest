package study.sort

class MergeSort(val arr: IntArray) {

    fun sortAsc(): IntArray {
        divide(0, arr.size - 1)
        return arr
    }

    private fun divide(first: Int, end: Int) {
        if(first < end) {
            val mid = (first + end) / 2
            divide(first, mid)
            divide(mid + 1, end)
            merge(first, mid, mid + 1, end)
        }
    }

    private fun merge(leftStart: Int, leftEnd: Int, rightStart: Int, rightEnd: Int) {
        val list = mutableListOf<Int>()

        var leftIndex = leftStart
        var rightIndex = rightStart

        while(leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if(arr[leftIndex] <= arr[rightIndex]) {
                list.add(arr[leftIndex])
                leftIndex++
            } else {
                list.add(arr[rightIndex])
                rightIndex++
            }
        }

        when {
            leftIndex > leftEnd -> {
                for(i in rightIndex..rightEnd) {
                    list.add(arr[i])
                }
            }
            rightIndex > rightEnd -> {
                for(i in leftIndex..leftEnd) {
                    list.add(arr[i])
                }
            }
        }

        for(i in 0..(rightEnd - leftStart)) {
            arr[leftStart + i] = list[i]
        }
    }
}
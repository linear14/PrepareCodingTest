package study.sort

class MergeSortDevelop(val arr: IntArray) {
    val sortedArr = IntArray(arr.size)

    fun sortAsc(): IntArray {
        divide(0, arr.size - 1)
        return arr
    }

    fun divide(start: Int, end: Int) {
        if(start < end) {
            val mid = (start + end) / 2
            divide(start, mid)
            divide(mid + 1, end)
            merge(start, mid, mid + 1, end)
        }
    }

    fun merge(leftStart: Int, leftEnd: Int, rightStart: Int, rightEnd: Int) {
        var leftIndex = leftStart
        var rightIndex = rightStart
        var pos = leftStart

        while(leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if(arr[leftIndex] < arr[rightIndex]) {
                sortedArr[pos++] = arr[leftIndex]
                leftIndex++
            } else {
                sortedArr[pos++] = arr[rightIndex]
                rightIndex++
            }
        }

        when {
            leftIndex > leftEnd -> {
                for(i in rightIndex..rightEnd) {
                    sortedArr[pos++] = arr[i]
                }
            }
            rightIndex > rightEnd -> {
                for(i in leftIndex..leftEnd) {
                    sortedArr[pos++] = arr[i]
                }
            }
        }

        for(i in leftStart..rightEnd) {
            arr[i] = sortedArr[i]
        }
    }

}
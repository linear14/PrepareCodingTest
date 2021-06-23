package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var sortArr: IntArray

/*private fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val list = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE

        list.forEach {
            if(min > it) {
                min = it
            }
            if(max < it) {
                max = it
            }
        }

        println("$min $max")
    }
}*/

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        sortArr = IntArray(n)

        sort(arr)
        bw.write("${arr[0]} ${arr[arr.size - 1]}\n")
    }
    bw.flush()
    bw.close()
}

private fun sort(arr: IntArray) {
    divide(arr, 0, arr.size - 1)
}

private fun divide(arr: IntArray, start: Int, end: Int) {
    if(start < end) {
        val mid = (start + end) / 2
        divide(arr, start, mid)
        divide(arr, mid + 1, end)
        merge(arr, start, mid, mid + 1, end)
    }
}

private fun merge(arr: IntArray, firstStart: Int, firstEnd: Int, secondStart: Int, secondEnd: Int) {
    var firstIndex = firstStart
    var secondIndex = secondStart
    var index = firstStart

    while(firstIndex <= firstEnd && secondIndex <= secondEnd) {
        if(arr[firstIndex] >= arr[secondIndex]) {
            sortArr[index++] = arr[secondIndex++]
        } else {
            sortArr[index++] = arr[firstIndex++]
        }
    }
    when {
        firstIndex > firstEnd -> {
            for(i in secondIndex..secondEnd) {
                sortArr[index++] = arr[i]
            }
        }
        secondIndex > secondEnd -> {
            for(i in firstIndex..firstEnd) {
                sortArr[index++] = arr[i]
            }
        }
    }
    for(i in firstStart..secondEnd) {
        arr[i] = sortArr[i]
    }
}
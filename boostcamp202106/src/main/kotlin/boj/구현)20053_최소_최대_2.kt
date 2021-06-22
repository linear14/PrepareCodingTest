package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine()!!
        val list = readLine()!!.split(" ").map { it.toInt() }

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
}

/*private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine()!!
        val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        sort(arr)
        bw.write("${arr[0]} ${arr[arr.size - 1]}\n")
    }
    bw.flush()
    bw.close()
}*/

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
    val tempList = mutableListOf<Int>()
    var firstIndex = firstStart
    var secondIndex = secondStart
    while(firstIndex <= firstEnd && secondIndex <= secondEnd) {
        if(arr[firstIndex] >= arr[secondIndex]) {
            tempList.add(arr[secondIndex])
            secondIndex++
        } else {
            tempList.add(arr[firstIndex])
            firstIndex++
        }
    }
    when {
        firstIndex > firstEnd -> {
            for(i in secondIndex..secondEnd) {
                tempList.add(arr[i])
            }
        }
        secondIndex > secondEnd -> {
            for(i in firstIndex..firstEnd) {
                tempList.add(arr[i])
            }
        }
    }
    for(i in 0 until tempList.size) {
        arr[firstStart + i] = tempList[i]
    }
}
package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private lateinit var sortArr: IntArray

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.toInt()
    val arr = IntArray(n) { readLine()!!.toInt() }
    sortArr = IntArray(n)

    sort(arr)
    arr.forEach { bw.write("$it\n") }
    bw.flush()
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

/*private fun merge(arr: IntArray, firstStart: Int, firstEnd: Int, secondStart: Int, secondEnd: Int) {
    var firstIndex = firstStart
    var secondIndex = secondStart
    var index = firstStart

    while(firstIndex <= firstEnd && secondIndex <= secondEnd) {
        if(arr[firstIndex] <= arr[secondIndex]) {
            sortArr[index++] = arr[firstIndex++]
        } else {
            sortArr[index++] = arr[secondIndex++]
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
}*/

private fun merge(arr: IntArray, firstStart: Int, firstEnd: Int, secondStart: Int, secondEnd: Int) {
    val list = mutableListOf<Int>()
    var firstIndex = firstStart
    var secondIndex = secondStart

    /*
        println(list.hashCode()) 를 사용해서 보면, 모두 같은 HashCode임을 알 수 있음.
        즉, 초기화를 할 때 마다, 기존의 list의 것들을 모두 없애주는 시간복잡도가 추가될것임.
     */
    println("list : ${list.hashCode()}")
    println("firstIndex : ${firstIndex.hashCode()}")


    while(firstIndex <= firstEnd && secondIndex <= secondEnd) {
        if(arr[firstIndex] <= arr[secondIndex]) {
            list.add(arr[firstIndex])
            firstIndex++
        } else {
            list.add(arr[secondIndex])
            secondIndex++
        }
    }

    when {
        firstIndex > firstEnd -> {
            for(i in secondIndex..secondEnd) {
                list.add(arr[i])
            }
        }
        secondIndex > secondEnd -> {
            for(i in firstIndex..firstEnd) {
                list.add(arr[i])
            }
        }
    }

    for(i in 0 until list.size) {
        arr[firstStart + i] = list[i]
    }
}

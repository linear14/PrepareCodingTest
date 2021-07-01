package programmers

class Solution11 {
    val map = mutableMapOf<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()

        course.forEach { len ->
            orders.forEach { str ->
                if(str.length >= len) {
                    work(str, len)
                }
            }

            val maxList = mutableListOf<String>()
            var max = -1
            for((key, value) in map) {
                if(value > 1) {
                    if(value > max) {
                        maxList.clear()
                        maxList.add(key)
                        max = value
                    } else if(value == max) {
                        maxList.add(key)
                    }
                }
            }
            maxList.forEach { answer.add(it) }
            map.clear()
        }

        return answer.sorted().toTypedArray()
    }

    private fun work(str: String, len: Int) {
        val arr = IntArray(len)
        backTracking(arr, str, 0)
    }


    private fun backTracking(arr: IntArray, str: String, level: Int) {
        if(level == arr.size) {
            var newStr = ""
            val list = mutableListOf<Char>()
            arr.forEach { list.add(str[it]) }
            list.sort()
            list.forEach { newStr += it }

            if(map.containsKey(newStr)) {
                map[newStr] = map[newStr]!! + 1
            } else {
                map[newStr] = 1
            }
            return
        }

        for(i in 0 until str.length) {
            arr[level] = i
            if(isPossible(arr, level)) {
                backTracking(arr, str, level + 1)
            }
            arr[level] = -1
        }
    }

    private fun isPossible(arr: IntArray, level: Int): Boolean {
        for(i in 0 until level) {
            if(arr[level] <= arr[i]) return false
        }
        return true
    }
}

class Solution11second {
    val combList = mutableListOf<String>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        val map = mutableMapOf<String, Int>()

        for(order in orders) {
            for(len in course) {
                if(order.length < len) { break }

                combList.clear()
                combination(order.toSortedSet().toList(), len, 0)
                combList.forEach {
                    val value = map[it] ?: 0
                    map[it] = value + 1
                }
            }
        }

        for(len in course) {
            val candidate = map.filter { it.key.length == len && it.value > 1 }
            val most = candidate.maxBy { it.value }?.value ?: continue
            answer.addAll(candidate.filter { it.value == most }.keys.toList())
        }

        return answer.sorted().toTypedArray()
    }

    fun combination(order: List<Char>, len: Int, start: Int, temp: String = "") {
        if(temp.length == len) {
            combList.add(temp)
        }

        var tmp = temp
        for(i in start until order.size) {
            tmp += order[i]
            combination(order, len, i + 1, tmp)
            tmp = tmp.substring(0, tmp.length - 1)
        }
    }
}
package boj

private fun main() {
    val arr = BooleanArray(30)
    repeat(28) {
        arr[readLine()!!.toInt() - 1] = true
    }
    arr.forEachIndexed { i, doSubmit ->
        if(!doSubmit) println(i + 1)
    }
}
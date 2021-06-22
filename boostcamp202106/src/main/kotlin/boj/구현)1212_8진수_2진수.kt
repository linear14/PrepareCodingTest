package boj

private fun main() {
    val n = readLine()!!
    val sb = StringBuilder()

    n.forEachIndexed { i, word ->
        when(word) {
            '0' -> "000"
            '1' -> "001"
            '2' -> "010"
            '3' -> "011"
            '4' -> "100"
            '5' -> "101"
            '6' -> "110"
            '7' -> "111"
            else -> ""
        }.also { sb.append(it) }
    }

    if(n == "0") {
        print(0)
    } else {
        val temp = sb.toString()
        val firstOnePos = temp.indexOf('1')
        print(temp.substring(firstOnePos))
    }
}

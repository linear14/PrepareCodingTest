package boj

private fun main() {
    val list = mutableListOf<Char>()
    readLine()!!.forEach {
        val index = when(it) {
            'q' -> list.indexOf('k')
            'u' -> list.indexOf('q')
            'a' -> list.indexOf('u')
            'c' -> list.indexOf('a')
            else -> list.indexOf('c')
        }

        if(index == -1) {
            if(it == 'q') {
                list.add('q')
            } else {
                println(-1)
                return
            }
        } else {
            list[index] = it
        }
    }

    list.forEach {
        if(it != 'k') {
            println(-1)
            return
        }
    }
    println(list.size)
}
package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sizes = mutableListOf<Int>()
    val list = mutableListOf<Array<String>>().apply {
        while(true) {
            val line = readLine() ?: break
            add(line.split(" ")
                    .filter { it.isNotEmpty() }
                    .toTypedArray()
                    .also { sizes.add(it.size) }
            )
        }
    }

    var maxSize = Integer.MIN_VALUE
    sizes.forEach { value ->
        if(maxSize < value) {
            maxSize = value
        }
    }

    for(i in 0 until maxSize) {
        var maxLength = Integer.MIN_VALUE
        list.forEachIndexed { idx, strList ->
            if(sizes[idx] > i) {
                if(maxLength < strList[i].length) {
                    maxLength = strList[i].length
                }
            }
        }

        list.forEachIndexed { idx, strList ->
            if(sizes[idx] > i) {
                val old = strList[i]
                list[idx][i] = old + (" ".repeat(maxLength - old.length + 1))
            }
        }
    }

    for(i in list.indices) {
        for(j in list[i].indices) {
            if(j == list[i].lastIndex) {
                bw.write(list[i][j].trim())
            } else {
                bw.write(list[i][j])
            }
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

/*
val words = mutableListOf(
        "  start:  integer;    // begins here",
        "stop: integer; //  ends here ",
        " s:  string;   ",
        "c:   char; // temp "
)
val list = mutableListOf<Array<String>>().apply {
    words.forEach {
        add(it.split(" ")
                .filter { it.isNotEmpty() }
                .toTypedArray()
                .also { sizes.add(it.size) }
        )
    }
}*/

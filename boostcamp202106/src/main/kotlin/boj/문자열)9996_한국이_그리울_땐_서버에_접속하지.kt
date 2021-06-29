package boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

/*
    히든 케이스
    1. a*a -> a
    2. ab*ba -> aba
    3. ab*aba -> aba

    대비
    (forth.length + back.length) <= name.length 인 경우에만 적용되도록 (아니면 "NE")
 */
private fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.toInt()
    val (forth, back) = readLine()!!.split("*")
    val minLength = forth.length + back.length

    loop@for(i in 1..n) {
        val name = readLine()!!

        if(minLength > name.length) {
            bw.write("NE\n")
            continue
        }

        for(j in forth.indices) {
            if(name[j] != forth[j]) {
                bw.write("NE\n")
                continue@loop
            }
        }
        for(j in back.indices) {
            if(name[name.length - 1 - j] != back[back.length - 1 - j]) {
                bw.write("NE\n")
                continue@loop
            }
        }
        bw.write("DA\n")
    }

    bw.flush()
    bw.close()
}
package programmers

import java.util.*

class Solution5 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.copyOfRange(it[0] - 1, it[1]).sorted().get(it[2] - 1)
        }.toIntArray()
    }
}
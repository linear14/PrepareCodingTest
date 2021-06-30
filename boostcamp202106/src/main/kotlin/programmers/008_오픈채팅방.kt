package programmers

import java.util.*

class Solution8 {
    fun solution(record: Array<String>): Array<String> {

        val user = mutableMapOf<String, String>()

        return record
                .map { it.split(" ") }
                .filter {
                    if(it[0] == "Enter" || it[0] == "Change") {
                        user[it[1]] = it[2]
                    }
                    it[0] != "Change"
                }
                .map { Pair(it[1], it[0]) }
                .map {
                    when(it.second) {
                        "Enter" -> "${user[it.first]!!}님이 들어왔습니다."
                        else -> "${user[it.first]!!}님이 나갔습니다."
                    }
                }
                .toTypedArray()
    }
}
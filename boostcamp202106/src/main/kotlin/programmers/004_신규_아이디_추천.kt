package programmers

import java.util.*

class Solution4 {
    fun solution(new_id: String): String {
        var ans = ""
        val chars = mutableListOf<Char>().apply {
            new_id.forEach { add(it) }
        }
        val temp = mutableListOf<Char>()

        for(i in chars.indices) {
            // 1단계
            if(chars[i] in 'A'..'Z') {
                chars[i] = chars[i] + ('a' - 'A')
            }

            // 2단계
            if(new_id[i] !in 'a'..'z' && new_id[i] !in '0'..'9' && new_id[i] != '-'
                    && new_id[i] != '_' && new_id[i] != '.') {
                temp.add(new_id[i])
            }
        }

        temp.forEach { chars.remove(it) }

        // 3단계
        var i = 0
        while(i < chars.size) {
            if(i != 0 && chars[i - 1] == '.' && chars[i] == '.') {
                chars.removeAt(i)
            } else {
                i++
            }
        }


        // 4단계
        if(chars.isNotEmpty()) {
            if(chars[0] == '.') { chars.removeAt(0) }
        }

        if(chars.isNotEmpty()) {
            if(chars[chars.size - 1] == '.') { chars.removeAt(chars.size - 1) }
        }


        // 5단계
        if(chars.isEmpty()) { chars.add('a') }

        // 6단계
        while(chars.size >= 16) {
            chars.removeAt(chars.size - 1)
        }
        if(chars.isNotEmpty()) {
            if(chars[chars.size - 1] == '.') { chars.removeAt(chars.size - 1) }
        }

        // 7단계
        while(chars.size <= 2) {
            chars.add(chars[chars.size - 1])
        }

        chars.forEach { ans += it.toString() }
        return ans
    }
}

class Solution4Second {
    fun solution(new_id: String): String =
        new_id.toLowerCase()
            .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
            .replace("[.]*[.]".toRegex(), ".")
            .removePrefix(".").removeSuffix(".")
            .let { if(it == "") "a" else it }
            .let { if(it.length >= 16) it.substring(0, 15) else it }.removeSuffix(".")
            .let {
                var str = ""
                while(it.length + str.length < 3) {
                    str += it.last()
                }
                it + str
            }

}
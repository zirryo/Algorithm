import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var map = hashMapOf<String, Int>()
        var answer = mutableListOf<Int>()
        for(i in terms.indices) {
            var token = terms[i].split(" ")
            map[token[0]] = token[1].toInt()
        }

        for(i in privacies.indices) {
            var token = privacies[i].split(" ")
            val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
            val todayInfo = LocalDate.parse(today, formatter)
            val privateInfo = LocalDate.parse(token[0], formatter)
            val expiration = privateInfo.plusMonths(map[token[1]]!!.toLong())
            if(expiration.compareTo(todayInfo) <= 0) answer.add(i+1)
        }
        return answer.toIntArray()
    }
}
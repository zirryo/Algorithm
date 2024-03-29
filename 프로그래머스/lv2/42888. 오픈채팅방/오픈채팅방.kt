class Solution {
    fun solution(record: Array<String>): Array<String> {
        val userInfo = mutableMapOf<String, String>()
        record.forEach {
            val token = it.split(" ")
            if(token[0] == "Enter" || token[0] == "Change") {
                userInfo[token[1]] = token[2]
            }
        }

        val ans = mutableListOf<String>()
        record.forEach {
            val token = it.split(" ")
            when(token[0]) {
                "Enter" -> ans.add("${userInfo[token[1]]}님이 들어왔습니다.")
                "Leave" -> ans.add("${userInfo[token[1]]}님이 나갔습니다.")
                else -> {}
            }
        }
        return ans.toTypedArray()
    }
}
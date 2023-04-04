class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size) { 0 }
        val reportedID = mutableMapOf<String, HashSet<String>>()
        val idIndex = mutableMapOf<String, Int>()

        id_list.forEachIndexed{ idx, id ->
            idIndex[id] = idx
        }
        for(reporting in report) {
            val token = reporting.split(" ")
            reportedID.putIfAbsent(token[1], HashSet())
            reportedID[token[1]]?.add(token[0])
        }
        for(id in id_list) {
            val reporter = reportedID[id]
            if(reporter != null && reporter.size >= k) {
                for(who in reporter) {
                    answer[idIndex[who]!!] += 1
                }
            }
        }
        return answer
    }
}
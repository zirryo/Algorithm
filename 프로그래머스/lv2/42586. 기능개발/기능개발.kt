class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var idx = 0
        val answer = mutableListOf<Int>()
        while (idx in progresses.indices) {
            var complete = 0
            for (i in idx until progresses.size) {
                progresses[i] += speeds[i]
            }
            for (i in idx until progresses.size) {
                if(progresses[i] >= 100) {
                    complete++
                } else break
            }
            if(complete != 0) answer.add(complete)
            idx += complete
        }
        return answer.toIntArray()
    }
}
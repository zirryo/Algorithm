class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val map = mutableMapOf<String, Int>()
        val totalWant = number.sum()
        if(totalWant > discount.size) return 0
        for (i in 0 until totalWant) {
            map[discount[i]] = map.getOrDefault(discount[i], 0) + 1
        }
        var answer = 0
        for(k in totalWant .. discount.size) {
            var flag = true
            for (i in want.indices) {
                if(map.getOrDefault(want[i], 0) < number[i]) {
                    flag = false
                    break
                }
            }
            if (flag) {
                answer++
            }
            if (k == discount.size) break
            map[discount[k]] = map.getOrDefault(discount[k], 0) + 1
            if(map[discount[k-totalWant]] == 1) map.remove(discount[k-totalWant])
            else map[discount[k-totalWant]] = map[discount[k-totalWant]]!! - 1

        }

        return answer
    }
}
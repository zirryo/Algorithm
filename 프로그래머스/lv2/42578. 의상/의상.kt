class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = HashMap<String, Int>()
        clothes.forEach {
            val kind = it[1]
            map[kind] = map.getOrDefault(kind, 0) + 1
        }
        var answer = 1
        map.values.forEach { answer *= (it+1) }
        return answer - 1
    }
}
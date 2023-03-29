class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var result = s
        var num = mutableListOf<String>("zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine")
        num.forEachIndexed{ idx, str ->
            result = result.replace(str, idx.toString())
        }
        return Integer.parseInt(result)
    }
}
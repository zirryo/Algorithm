class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var zeros = 0
        var sameNums = 0
        for (num in lottos) if(num == 0) zeros++
        for(i in 0 until 6) {
            for(j in 0 until 6) {
                if(lottos[i] == win_nums[j]) sameNums++
            }
        }
        fun rank(n: Int) = if(n < 2) 6 else 7 - n
        return intArrayOf(rank(sameNums + zeros), rank(sameNums))
    }
}
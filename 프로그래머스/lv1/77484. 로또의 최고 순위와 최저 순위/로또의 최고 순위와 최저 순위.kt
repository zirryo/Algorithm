class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    val answer = IntArray(2) { 0 }
    var zeros = 0
    var sameNums = 0
    for (num in lottos) if(num == 0) zeros++
    for(i in 0 until 6) {
        for(j in 0 until 6) {
            if(lottos[i] == win_nums[j]) sameNums++
        }
    }
    if(sameNums >= 2) answer[1] = 7 - sameNums
    else answer[1] = 6
    if(zeros + sameNums >= 2) answer[0] = 7 - zeros - sameNums
    else answer[0] = 6
    
    return answer
    }
}
import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q : Queue<Pair<Int, Int>> = LinkedList()
        priorities.forEachIndexed { idx, i ->
            q.add(Pair(idx, i))
        }
        var ans = 0
        while (!q.isEmpty()) {
            val cur = q.poll()
            var cnt = 0
            var flag = true
            for(i in q) {
                if(cur.second < i.second) {
                    flag = false
                    break
                } else {
                    cnt++
                }
            }
            if(flag) {
                ans++
                if(location == cur.first) break
                else continue
            }
            q.add(cur)
            for(j in 0 until cnt) {
                q.add(q.poll())
            }
        }
        return ans
    }
}
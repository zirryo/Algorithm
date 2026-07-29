import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int len = enemy.length;
        
        if (k >= len) {
            return len;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < len; i++) {
            int cur = enemy[i];
            n -= cur;
            pq.add(cur);

            if (n < 0) {
                if (k > 0) {
                    n += pq.poll(); // 해당 라운드에 무적권을 사용한 것으로 간주
                    k--;
                } else {
                    return i;
                }
            }
        }

        return len;
    }
}
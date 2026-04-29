import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        long target = (sum1 + sum2) / 2;
        // 총합이 홀수면 무조건 불가능
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        int count = 0;
        // 최대 반복 횟수 설정 (4 * N)
        int limit = n * 4;
        
        while (count <= limit) {
            if (sum1 == target) return count;
            
            if (sum1 > target) {
                int val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.add(val);
            } else {
                int val = q2.poll();
                sum2 -= val;
                sum1 += val;
                q1.add(val);
            }
            count++;
        }
        
        return -1;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int mixCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();
            int sum = first + (second * 2);
            pq.add(sum);
            mixCount++;
        }
        
        return mixCount;
    }
}
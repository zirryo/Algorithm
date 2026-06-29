import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int days = score.length;
        int[] answer = new int[days];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < days; i++) {
            pq.add(score[i]);
            
            if (pq.size() > k) {
                pq.poll();
            }
            
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}
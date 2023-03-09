class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del = 0;
        int pick = 0;
        for(int i=n-1; i>=0; i--) {
            int move = 0;
            del += deliveries[i];
            pick += pickups[i];
            while(del > 0 || pick > 0) {
                del -= cap;
                pick -= cap;
                move++;
            }
            answer += ((i+1) * 2 * move);
        }
        return answer;
    }
}
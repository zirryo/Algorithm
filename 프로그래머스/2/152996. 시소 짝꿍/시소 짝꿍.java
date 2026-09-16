import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        long[] count = new long[1001];
        
        for (int w : weights) {
            count[w]++;
        }

        for (int i = 100; i <= 1000; i++) {
            if (count[i] >= 2) {
                answer += (count[i] * (count[i] - 1)) / 2;
            }
        }

        for (int w = 100; w <= 1000; w++) {
            if (count[w] == 0) continue;

            // 2:3
            if (w * 3 % 2 == 0 && w * 3 / 2 <= 1000) {
                answer += count[w] * count[w * 3 / 2];
            }
            // 2:4
            if (w * 2 <= 1000) {
                answer += count[w] * count[w * 2];
            }
            // 3:4
            if (w * 4 % 3 == 0 && w * 4 / 3 <= 1000) {
                answer += count[w] * count[w * 4 / 3];
            }
        }

        return answer;
    }
}
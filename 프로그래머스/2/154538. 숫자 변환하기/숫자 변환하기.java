import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[y] = 0; 

        for (int i = y; i >= x; i--) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            if (i % 3 == 0 && i / 3 >= x) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }

            if (i % 2 == 0 && i / 2 >= x) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }

            if (i - n >= x) {
                dp[i - n] = Math.min(dp[i - n], dp[i] + 1);
            }
        }

        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }
}
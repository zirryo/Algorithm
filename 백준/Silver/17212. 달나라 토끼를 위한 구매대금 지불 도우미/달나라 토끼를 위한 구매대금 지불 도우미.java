import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MAX = 100_000;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        int[] coins = {1, 2, 5, 7};

        for (int i = 1; i <= N; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != MAX) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }
}
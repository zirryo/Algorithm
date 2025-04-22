import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dp = new int[N + 1];
        dp[0] = 1; 

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i >= M) {
                dp[i] = (dp[i] + dp[i - M]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}

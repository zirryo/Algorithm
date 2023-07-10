import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int val = 50000;
            for (int j = 1; j*j <= i; j++) {
                val = Math.min(val, dp[i - j*j]);
            }
            dp[i] = val + 1;
        }
        System.out.println(dp[N]);
    }
}
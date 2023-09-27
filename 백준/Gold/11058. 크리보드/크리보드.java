import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        for (int i = 1; i <= N; i++) {
            if (i <= 6) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + 1;
            for (int j = 2; j <= 5; j++) {
                dp[i] = Math.max(dp[i], dp[i - (j+1)] * j);
            }

        }

        System.out.println(dp[N]);
    }
}
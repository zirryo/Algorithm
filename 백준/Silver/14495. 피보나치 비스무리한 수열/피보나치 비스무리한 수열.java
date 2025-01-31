import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n <= 3) System.out.println(1);
        else {
            long[] dp = new long[n + 1];
            dp[1] = 1L;
            dp[2] = 1L;
            dp[3] = 1L;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 1];
            }

            System.out.println(dp[n]);
        }
    }
}
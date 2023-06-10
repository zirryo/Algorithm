import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[2][N+1];

        dp[0][1] = 0;
        dp[1][1] = 1;

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }
        else {
            for (int i=2; i<=N; i++) {
                dp[0][i] = dp[0][i-1] + dp[1][i-1];
                dp[1][i] = dp[0][i-1];
            }
        }
        System.out.println(dp[0][N] + dp[1][N]);
    }
}
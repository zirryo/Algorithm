import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        if (N == 2) {
            System.out.println(1);
            return;
        }

        BigInteger[] dp = new BigInteger[N + 1];
        dp[1] = BigInteger.ZERO;
        dp[2] = BigInteger.ONE;

        for (int i = 3; i <= N; i++) {
            // dp[i] = dp[i-1] + dp[i-2] * 2
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        System.out.println(dp[N]);
    }
}
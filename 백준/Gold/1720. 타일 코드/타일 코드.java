import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2] * 2;
        }

        int result = (dp[N] + dp[N/2]) / 2;
        if (N % 2 == 1) System.out.println(result);
        else System.out.println(result + dp[N/2  - 1]);
    }
}
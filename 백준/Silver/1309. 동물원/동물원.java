import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MOD = 9901;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        dp[1][0] = 1; // 첫번쨰 행에 사자가 없는 경우
        dp[1][1] = 1; // 첫번째 행 왼쪽 칸에 사자가 있는 경우
        dp[1][2] = 1; // 첫번째 행 오른쪽 칸에 사자가 있는 경우

        for(int i=2; i<=N; i++) {
            // i번째 행에 사자가 없으면, i-1 행은 모든 경우가 가능함.
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;

            // i번째 행 왼쪽에 사자가 있는 경우, i-1 행은 오른쪽에 사자가 있거나 비어 있어야 함.
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;

            // i번째 행 오른쪽에 사자가 있는 경우, i-1 행은 왼쪽에 사자가 있거나 비어 있어야 함.
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_009;
        int[][] dp = new int[100001][4];
        dp[1]= new int[]{0, 1, 0, 0};
        dp[2]= new int[]{0, 0, 1, 0};
        dp[3]= new int[]{0, 1, 1, 1};

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int result = ((dp[N][1] + dp[N][2]) % MOD + dp[N][3]) % MOD;
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
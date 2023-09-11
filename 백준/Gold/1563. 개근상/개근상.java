import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 1_000_000;
    static int N;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3][4]; // 지각 총 2회, 결석 연속 3회 지속시 개근상 제외

        for (int i=0; i<N; i++) {
            for (int j=0; j<3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(dfs(0, 0, 0) % MOD);
    }
    private static int dfs(int day, int late, int absent) {
        if (late >= 2 || absent >= 3) return 0;
        if (day == N) return 1;
        if (dp[day][late][absent] != -1) return dp[day][late][absent];
        return dp[day][late][absent] = dfs(day+1, late, 0) % MOD
                + dfs(day+1, late+1, 0) % MOD + dfs(day+1, late, absent+1) % MOD;
    }
}
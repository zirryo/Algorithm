import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] time, money, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 수
        K = Integer.parseInt(st.nextToken()); // 최대 소요 시간
        time = new int[N+1][2]; // 0 - 도보, 1 - 자전거
        money = new int[N+1][2]; // 0 - 도보, 1 - 자전거
        dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            money[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
            money[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        System.out.println(findMaxMoney(N, K));
    }
    private static int findMaxMoney(int n, int k) {
        if (n == 0) return 0;
        if (dp[n][k] != -1) return dp[n][k];

        dp[n][k] = -1_000_000_000;

        for (int i=0; i<2; i++) {
            if (k - time[n][i] >= 0) {
                dp[n][k] = Math.max(dp[n][k], findMaxMoney(n-1, k - time[n][i]) + money[n][i]);
            }
        }

        return dp[n][k];
    }
}
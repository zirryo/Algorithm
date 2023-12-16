import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static final int MAX = 500 * 4000;
    static int[][] cord, dist, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        cord = new int[N+1][2];
        dist = new int[N+1][N+1];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cord[i][0] = Integer.parseInt(st.nextToken());
            cord[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            for (int j = i+1; j <= N; j++) {
                dist[i][j] = Math.abs(cord[i][0] - cord[j][0]) + Math.abs(cord[i][1] - cord[j][1]);
            }
        }
        System.out.println(marathon(N, K));
    }
    private static int marathon(int idx, int skip) {
        if (dp[idx][skip] != 0) return dp[idx][skip];
        if (idx == 1) return 0; // 1번지점은 출발지

        int temp = MAX;
        for (int i = 0; i <= skip; i++) {
            if (idx - i > 1) {
                temp = Math.min(marathon(idx-i-1, skip-i)
                        + dist[idx-i-1][idx], temp);
            }
        }
        return dp[idx][skip] = temp;
    }
}
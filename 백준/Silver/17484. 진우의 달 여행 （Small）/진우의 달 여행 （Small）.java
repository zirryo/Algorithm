import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, MAX = 999;
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
               dp[0][i][j] = map[0][i]; // 맨윗줄(지구)
            }
        }

        for (int i = 1; i < N; i++) {
            dp[i][0][0] = MAX; // 불가능 (좌상단 -> 현재칸)
            dp[i][M-1][2] = MAX; // 불가능 (우상단 -> 현재칸)

            for (int j = 0; j < M; j++) {
                if (j >= 1) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];
                }
                if (j < M - 1) {
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + map[i][j];
                }
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];
            }
        }

        int result = MAX;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[N-1][i][j]);
            }
        }

        System.out.println(result);
    }
}
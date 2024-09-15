import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100 * 1000;
    static int[][] map;
    static int[][][] dp;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], INF);
            }
        }
        
        for (int j = 0; j < M; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = map[0][j];
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j-1][1] + map[i][j]);
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i-1][j-1][2] + map[i][j]);
                }
                
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i-1][j][0] + map[i][j]);
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i-1][j][2] + map[i][j]);
                
                if (j < M - 1) {
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i-1][j+1][0] + map[i][j]);
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i-1][j+1][1] + map[i][j]);
                }
            }
        }
        
        int answer = INF;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                answer = Math.min(answer, dp[N-1][j][k]);
            }
        }

        System.out.println(answer);
    }
}

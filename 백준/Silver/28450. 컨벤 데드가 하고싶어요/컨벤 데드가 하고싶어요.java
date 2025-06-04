import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static long[][] dp;
    static long H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        H = Long.parseLong(br.readLine());

        dp[0][0] = map[0][0];
        for (int i = 1; i < N; i++) dp[i][0] = dp[i-1][0] + map[i][0];
        for (int j = 1; j < M; j++) dp[0][j] = dp[0][j-1] + map[0][j];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + map[i][j];
            }
        }

        if (dp[N-1][M-1] <= H) {
            System.out.println("YES");
            System.out.println(dp[N-1][M-1]);
        } else {
            System.out.println("NO");
        }
    }
}

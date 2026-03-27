import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] v = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                v[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[2][M];

        for (int j = 0; j < M; j++) {
            dp[0][j] = v[j][0];
        }

        for (int i = 1; i < N; i++) {
            int curr = i % 2;
            int prev = (i - 1) % 2;

            // 전날(prev)의 최댓값과 두 번째 최댓값 찾기
            long max1 = -1, max2 = -1;
            int idx1 = -1;

            for (int j = 0; j < M; j++) {
                if (dp[prev][j] > max1) {
                    max2 = max1;
                    max1 = dp[prev][j];
                    idx1 = j;
                } else if (dp[prev][j] > max2) {
                    max2 = dp[prev][j];
                }
            }

            for (int j = 0; j < M; j++) {
                long diffCase = (j == idx1) ? max2 : max1;
                long option1 = diffCase + v[j][i];

                long option2 = dp[prev][j] + (v[j][i] / 2);

                dp[curr][j] = Math.max(option1, option2);
            }
        }

        long ans = 0;
        int finalRow = (N - 1) % 2;
        for (int j = 0; j < M; j++) {
            ans = Math.max(ans, dp[finalRow][j]);
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] milkMap;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        milkMap = new int[N][N];
        dp = new int[N][N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                milkMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (milkMap[0][0] == 0) dp[0][0][0] = 1;

        for (int i = 1; i < N; i++) {
            int milk = milkMap[0][i];
            dp[0][i][0] = milk == 0 ? dp[0][i-1][2] + 1 : dp[0][i-1][0];
            dp[0][i][1] = (milk == 1 && dp[0][i][2] < dp[0][i][0]) ? dp[0][i-1][0] + 1 : dp[0][i-1][1];
            dp[0][i][2] = (milk == 2 && dp[0][i][0] < dp[0][i][1]) ? dp[0][i-1][1] + 1 : dp[0][i-1][2];
        }

        for (int i = 1; i < N; i++) {
            int milk = milkMap[i][0];
            dp[i][0][0] = milk == 0 ? dp[i-1][0][2] + 1 : dp[i-1][0][0];
            dp[i][0][1] = (milk == 1 && dp[i][0][2] < dp[i][0][0]) ? dp[i-1][0][0] + 1 : dp[i-1][0][1];
            dp[i][0][2] = (milk == 2 && dp[i][0][0] < dp[i][0][1]) ? dp[i-1][0][1] + 1 : dp[i-1][0][2];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int milk = milkMap[i][j];

                dp[i][j][0] = milk == 0 ?  Math.max(dp[i][j-1][2] + 1, dp[i-1][j][2] + 1)
                        : Math.max(dp[i][j-1][0], dp[i-1][j][0]);
                dp[i][j][1] = (milk == 1 && dp[i][j][2] < dp[i][j][0]) ?
                        Math.max(dp[i][j-1][0] + 1, dp[i-1][j][0] + 1)
                        : Math.max(dp[i][j-1][1], dp[i-1][j][1]);
                dp[i][j][2] = (milk == 2 && dp[i][j][0] < dp[i][j][1]) ?
                        Math.max(dp[i][j-1][1] + 1, dp[i-1][j][1] + 1)
                        : Math.max(dp[i][j-1][2], dp[i-1][j][2]);
            }
        }

        int ans = Math.max(dp[N-1][N-1][0], Math.max(dp[N-1][N-1][1], dp[N-1][N-1][2]));
        System.out.println(ans);
    }
}

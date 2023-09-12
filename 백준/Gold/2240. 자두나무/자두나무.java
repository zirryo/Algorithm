import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T+1][W+1];

        for (int i = 1; i <= T; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 1) dp[i][0] = dp[i-1][0] + 1;

            for (int j = 1; j <= W; j++) {
                if ((j % 2 == 0 && x == 1) || (j % 2 == 1 && x == 2)) {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= W; i++) {
            result = Math.max(result, dp[T][i]);
        }

        System.out.println(result);
    }
}
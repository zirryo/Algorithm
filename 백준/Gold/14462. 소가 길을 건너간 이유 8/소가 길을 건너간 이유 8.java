import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] left = new int[N + 1];
        int[] right = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            left[i] = Integer.parseInt(br.readLine().trim());
        }
        for (int i = 1; i <= N; i++) {
            right[i] = Integer.parseInt(br.readLine().trim());
        }

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (Math.abs(left[i] - right[j]) <= 4) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String board = br.readLine();
        String word = br.readLine();

        int[][] dp = new int[2][N];
        int maxScore = 0;

        for (int i = 0; i < N; i++) {
            if (board.charAt(i) == word.charAt(0)) {
                dp[0][i] = 1;
                maxScore = 1;
            }
        }

        for (int j = 1; j < M; j++) {
            int cur = j % 2;
            int prev = (j + 1) % 2;
            Arrays.fill(dp[cur], 0);

            for (int i = 0; i < N; i++) {
                int best = 0;
                if (i > 0) best = Math.max(best, dp[prev][i - 1]);
                if (i < N - 1) best = Math.max(best, dp[prev][i + 1]);
                if (board.charAt(i) == word.charAt(j)) {
                    dp[cur][i] = best + 1;
                } else {
                    dp[cur][i] = best;
                }
                maxScore = Math.max(maxScore, dp[cur][i]);
            }
        }

        System.out.println(maxScore);
    }
}

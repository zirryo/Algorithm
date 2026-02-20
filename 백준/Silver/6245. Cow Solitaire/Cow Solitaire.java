import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = getScore(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];

        dp[N - 1][0] = board[N - 1][0];

        for (int r = N - 1; r >= 0; r--) {
            for (int c = 0; c < N; c++) {
                if (r == N - 1 && c == 0) continue;

                int fromDown = -1;
                int fromLeft = -1;

                if (r + 1 < N) {
                    fromDown = dp[r + 1][c];
                }

                if (c - 1 >= 0) {
                    fromLeft = dp[r][c - 1];
                }

                dp[r][c] = Math.max(fromDown, fromLeft) + board[r][c];
            }
        }

        System.out.println(dp[0][N - 1]);
    }

    private static int getScore(String card) {
        char val = card.charAt(0);
        switch (val) {
            case 'A': return 1;
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            default: return val - '0';
        }
    }
}
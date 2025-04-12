import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N + 1][N + 1];
        int[][] prefix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = grid[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int k = 1; k <= N; k++) {
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= N; j++) {
                    int total = prefix[i][j]
                            - prefix[i - k][j]
                            - prefix[i][j - k]
                            + prefix[i - k][j - k];
                    maxProfit = Math.max(maxProfit, total);
                }
            }
        }

        System.out.println(maxProfit);
    }
}

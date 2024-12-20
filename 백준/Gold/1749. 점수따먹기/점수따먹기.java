import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = grid[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        long maxSum = getMaxSum(n, m, prefixSum);
        System.out.println(maxSum);
    }

    private static long getMaxSum(int n, int m, int[][] prefixSum) {
        long maxSum = Long.MIN_VALUE;
        for (int startRow = 1; startRow <= n; startRow++) {
            for (int startCol = 1; startCol <= m; startCol++) {
                for (int endRow = startRow; endRow <= n; endRow++) {
                    for (int endCol = startCol; endCol <= m; endCol++) {
                        long sum = prefixSum[endRow][endCol]
                                - prefixSum[startRow - 1][endCol]
                                - prefixSum[endRow][startCol - 1]
                                + prefixSum[startRow - 1][startCol - 1];
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;
    }
}

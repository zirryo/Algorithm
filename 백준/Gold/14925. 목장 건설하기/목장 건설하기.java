import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] land, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        land = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findLargestSquare());
    }

    static int findLargestSquare() {
        int maxSize = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (land[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize;
    }
}

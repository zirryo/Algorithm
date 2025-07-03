import java.util.*;
import java.io.*;

public class Main {
    static int getScore(int diff) {
        if (diff <= 15) return 7;
        if (diff <= 23) return 6;
        if (diff <= 43) return 4;
        if (diff <= 102) return 2;
        return 0;
    }

    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] expected = new int[n];
        int[] actual = new int[m];

        for (int i = 0; i < n; i++) {
            expected[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            actual[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // 점수 획득 가능한 범위만 탐색
            int early = lowerBound(actual, expected[i - 1] - 102);
            int late = upperBound(actual, expected[i - 1] + 102);

            for (int j = early; j < late; j++) {
                int diff = Math.abs(expected[i - 1] - actual[j]);
                int score = getScore(diff);
                if (score > 0) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i - 1][j] + score);
                }
            }

            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}

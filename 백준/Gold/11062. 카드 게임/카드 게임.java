import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] cards = new int[N];
            int[] prefixSum = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                prefixSum[i + 1] = prefixSum[i] + cards[i];
            }

            // dp[i][j]: i번째부터 j번째 카드까지 남았을 때, 현재 차례에서 획득 가능한 최대 점수
            int[][] dp = new int[N][N];

            for (int len = 1; len <= N; len++) {
                for (int i = 0; i <= N - len; i++) {
                    int j = i + len - 1;

                    if (i == j) {
                        dp[i][j] = cards[i];
                    } else {
                        int curSum = prefixSum[j + 1] - prefixSum[i];
                        dp[i][j] = curSum - Math.min(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            sb.append(dp[0][N - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
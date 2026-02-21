import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] candyCnt = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            candyCnt[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j]: i개의 상자 선택 후, 총 사탕 개수를 K로 나눈 나머지가 j인 최대 사탕 수
        int[][] dp = new int[M + 1][K];
        for (int i = 0; i <= M; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                if (dp[i][j] == -1) continue;

                for (int candy : candyCnt) {
                    int nextRemain = (j + candy) % K;
                    dp[i + 1][nextRemain] = Math.max(dp[i + 1][nextRemain], dp[i][j] + candy);
                }
            }
        }

        int maxCandies = 0;
        for (int i = 0; i <= M; i++) {
            if (dp[i][0] != -1) {
                maxCandies = Math.max(maxCandies, dp[i][0]);
            }
        }

        System.out.println(maxCandies);
    }
}
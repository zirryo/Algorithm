import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // dp[i] : 지환의 현재 위치가 i번 세로선일 확률
        double[] dp = new double[N + 1];
        dp[S] = 1.0;

        double prob = 1.0 / (N - 1);

        for (int k = 0; k < M; k++) {
            // k 번째 상태는 k-1번째 상태에 의존하므로 일차원 배열 활용
            double[] nextDp = new double[N + 1];

            for (int j = 1; j <= N; j++) {
                if (dp[j] == 0) continue;

                // j번 세로선에 연결된 구간은 (j-1, j)와 (j, j+1) 최대 2개
                int lines = 0;
                if (j > 1) {
                    nextDp[j - 1] += dp[j] * prob;
                    lines++;
                }
                if (j < N) {
                    nextDp[j + 1] += dp[j] * prob;
                    lines++;
                }

                // 가로선이 j와 상관없는 곳에 추가될 확률
                nextDp[j] += dp[j] * (1.0 - lines * prob);
            }
            dp = nextDp;
        }

        System.out.printf("%.10f\n", dp[E]);
    }
}
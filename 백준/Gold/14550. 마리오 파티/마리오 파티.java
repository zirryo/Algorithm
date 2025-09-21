import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int NEG_INF = -1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            int[] board = new int[N + 2];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                board[i] = Integer.parseInt(st.nextToken());
            }
            board[N + 1] = 0;

            int[][] dp = new int[T + 1][N + 2 + S];
            for (int i = 0; i <= T; i++) {
                Arrays.fill(dp[i], NEG_INF);
            }

            dp[0][0] = 0;
            int ans = NEG_INF;

            for (int t = 1; t <= T; t++) {
                for (int pos = 0; pos <= N + 1; pos++) {
                    if (dp[t - 1][pos] == NEG_INF) continue;
                    for (int dice = 1; dice <= S; dice++) {
                        int next = pos + dice;
                        if (next >= N + 1) {
                            ans = Math.max(ans, dp[t - 1][pos]);
                        } else {
                            dp[t][next] = Math.max(dp[t][next],
                                    dp[t - 1][pos] + board[next]);
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

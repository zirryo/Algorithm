import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] woks = new int[M];
        boolean[] combined = new boolean[20001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            woks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            combined[woks[i]] = true;
            for (int j = i + 1; j < M; j++) {
                combined[woks[i] + woks[j]] = true;
            }
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        combined[0] = true;

        for (int i = 1; i <= N; i++) {
            if (!combined[i]) continue;
            for (int j = i; j <= N; j++) {
                if (dp[j - i] != Integer.MAX_VALUE) { 
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}

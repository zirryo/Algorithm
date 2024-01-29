import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 최대 공부시간
        int K = Integer.parseInt(st.nextToken()); // 과목 수
        int[] important = new int[K+1];
        int[] time = new int[K+1];
        int[][] dp = new int[K+1][T+1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            important[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= K; i++) { // 과목
            for (int j = 1; j <= T; j++) { // 시간
                if (time[i] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - time[i]] + important[i]);
            }
        }

        System.out.println(dp[K][T]);
    }
}
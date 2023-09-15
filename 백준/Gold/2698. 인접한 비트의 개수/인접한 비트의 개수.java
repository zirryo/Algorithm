import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][][] dp = new int[101][101][2];
        dp[1][0][0]++;
        dp[1][0][1]++;

        for (int i = 0; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                if (i == 0) dp[j][i][1] = dp[j-1][i][0];
                else dp[j][i][1] = dp[j-1][i-1][1] + dp[j-1][i][0];
                dp[j][i][0] = dp[j-1][i][0] + dp[j-1][i][1];
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            sb.append(dp[N][K][0] + dp[N][K][1]).append("\n");
        }

        System.out.println(sb);
    }
}
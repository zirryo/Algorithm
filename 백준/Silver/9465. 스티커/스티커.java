import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            int[][] cost = new int[2][N];
            int[][] dp = new int[2][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                cost[0][i] = Integer.parseInt(st.nextToken());
                cost[1][i] = Integer.parseInt(st1.nextToken());
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];

            int max = Math.max(dp[0][0], dp[1][0]);

            if(N > 1) {
                dp[0][1] = dp[1][0] + cost[0][1]; // 가로, 세로 인접하지 않도록 선택
                dp[1][1] = dp[0][0] + cost[1][1]; // 가로, 세로 인접하지 않도록 선택
                max = Math.max(dp[0][1], dp[1][1]);

                for(int i=2; i<N; i++) {
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + cost[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + cost[1][i];
                    max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
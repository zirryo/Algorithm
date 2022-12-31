import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                int L = Integer.parseInt(st.nextToken());
                dp[i][j] = L + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        while(K-- >0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}
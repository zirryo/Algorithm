import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, result;
    static final int INF = 1000 * 1000 + 1;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        init();

        for(int start=0; start<3; start++) { // start - 0(R), 1(G), 2(B)
            int[][] dp = new int[1001][3];
            for(int k=0; k<3; k++) {
                if(k == start) dp[1][start] = cost[1][start]; // 시작 색 고정
                else dp[1][k] = INF;
            }
            for(int i=2; i<=N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
            }

            for(int end=0; end<3; end++) { // 시작과 끝의 색이 같지 않도록 조건 지정
                if(start != end) result = Math.min(result, dp[N][end]);
            }
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = INF;
        cost = new int[1001][3];
        for(int i=1; i<=N; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
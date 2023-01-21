import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[] memory;
    static int[] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 10001;

        memory = new int[N+1];
        cost = new int[N+1];
        dp = new int[N+1][10001]; //// 최대 단일 코스트(100) * 최대 앱 수(100) = 10000

        st = new StringTokenizer(br.readLine());
        st1 = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i=1; i<=N; i++) { // i : 앱
            for(int j=1; j<10001; j++) { // j : 비활성화 비용
                if(j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i]] + memory[i]);
                    // 줄일 수 있는 최대 메모리의 값 저장
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if(dp[i][j] >= M) result = Math.min(result, j);
                // 줄일 수 있는 메모리의 값이 목표치 보다 크다면, 비용이 최소인지 확인
            }
        }

        System.out.println(result);
    }
}
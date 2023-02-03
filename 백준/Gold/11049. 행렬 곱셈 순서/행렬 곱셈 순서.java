import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        int[][] dp = new int[N][N];
        // dp[i][j] : i 번째 행렬 ~ j 번째 행렬까지 최소 곱셉연산 횟

        for(int i=0; i<N-1; i++) {
            dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
            // matrix[i][1] == matrix[i+1][0] 이므로 두 값 중 아무거나 사용해도 됨.
        }

        for(int j=2; j<N; j++) { // j : 연산에 사용되는 행렬의 수 - 1 (인접 행렬의 곱을 알고 있으므로 2(행렬3개)에서 시작)
            for(int i=0; i+j<N; i++) {
                dp[i][i+j] = Integer.MAX_VALUE;

                for(int k=i; k<i+j; k++) {
                    dp[i][i+j] = Math.min(dp[i][i+j],
                            dp[i][k] + dp[k+1][i+j] + matrix[i][0] * matrix[k][1] * matrix[i+j][1]);
                }
            }
        }

        int result = dp[0][N-1];
        sb.append(result);
    }
}
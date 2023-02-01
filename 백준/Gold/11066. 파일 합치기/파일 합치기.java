import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sum; // 파일 누적합
    static int[] files; // 파일 크기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            init();
            sb.append(mergeFiles()).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        sum = new int[N];
        files = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            files[i] = Integer.parseInt(st.nextToken());
            if(i==0) sum[i] = files[i];
            else sum[i] = sum[i-1] + files[i];
        }
    }

    private static int mergeFiles() {
        int[][] dp = new int[N][N]; // dp[i][j] : 파일 i ~ 파일 j 합치는 최소 비용

        for(int i=0; i<N-1; i++) {
            dp[i][i+1] = files[i] + files[i+1]; // 인접 파일을 합친 값을 저장함
        }

        for(int j=2; j<N; j++) {
            for(int i=0; i+j<N; i++) { // i - 시작점, j - 끝점
                for(int k=i; k<i+j; k++) {
                    if(dp[i][i+j] == 0) {
                        dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + prefixSum(i, i+j);
                    } else {
                        dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k] + dp[k+1][i+j] + prefixSum(i, i+j));
                    }
                }
            }
        }
        return dp[0][N-1]; // 1~N 을 합치는 최소 비용 리턴
    }

    private static int prefixSum(int start, int end) {
        if(start == 0) return sum[end];
        return sum[end] - sum[start-1];
    }
}
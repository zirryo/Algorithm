import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sumArr;
    static int[][] dp;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        sumArr = new int[N+1];
        dp = new int[4][N+1];

        for (int i = 1; i <= N; i++) sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; i++) {
            for (int j = i * K; j <= N; j++) { // i: 기관차, j:객차
                dp[i][j] = Math.max(dp[i][j-1], sumArr[j] - sumArr[j-K] + dp[i-1][j-K]);
                // i번째 기관차가 j번째 까지 진행했을 때 최대 승객수는
                // 1 - 현재 객차 미선택(이전 객차 최대 승객수 그대로)하는 경우
                // 2 - 이번 객차를 기관차의 꼬리칸으로 선택하는 경우
            }
        }
        System.out.println(dp[3][N]);
    }
}
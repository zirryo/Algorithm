import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true; // 팰린드롬 길이 '1'인 경우
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true; // 팰린드롬 길이 '2'인 경우
            }
        }

        for (int i = 2; i <= N-1; i++) { // i : 팰린드롬의 길이 (시작 위치 미포함)
            for (int j = 1; i + j <= N; j++) { // j : 팰린드롬 체크를 시작하는 위치
                if (arr[j] == arr[i+j] && dp[j+1][i+j-1]) {
                    dp[j][i+j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (dp[s][e]) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);
    }
}
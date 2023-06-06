import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] t;
    static int[] p;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        t = new int[N];
        p = new int[N];
        dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int due;
        for (int i = N-1; i >= 0; i--) {
            due = i + t[i];
            if (due > N) dp[i] = dp[i+1]; // 퇴사 전에 끝낼 수 없는 업무
            else dp[i] = Math.max(dp[i+1], dp[due] + p[i]);
        }
        System.out.println(dp[0]);
    }
}
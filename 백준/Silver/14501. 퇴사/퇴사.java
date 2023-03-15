import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] ti;
    static int[] pi;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(dp[1]); // top-down 방식
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ti = new int[N + 1];
        pi = new int[N + 1];
        dp = new int[N + 2]; // N+1일에 퇴사
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            ti[i] = Integer.parseInt(st.nextToken());
            pi[i] = Integer.parseInt(st.nextToken());
        }
    }
    private static void solve() {
        int due;
        for(int i = N; i >= 1; i--) {
            due = i + ti[i]; // 해당 업무를 끝내는 날
            if(due > N + 1) { // 끝낼 수 없는 업무
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[due] + pi[i]);
            }
        }
    }
}
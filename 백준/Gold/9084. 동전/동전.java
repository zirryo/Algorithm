import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i=0; i<N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[M+1];
            sb.append(solve()).append("\n");
        }
        System.out.println(sb);
    }
    private static int solve() {
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j<=M; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        
        return dp[M];
    }
}
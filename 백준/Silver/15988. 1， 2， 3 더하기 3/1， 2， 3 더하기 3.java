import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            sb.append(finddp(x)).append("\n");
        }

        System.out.println(sb);
    }
    public static long finddp(int n) {
        if(n <= 3 || dp[n] != 0) return dp[n];
        return dp[n] = (finddp(n - 1) + finddp(n - 2) + finddp(n - 3)) % 1_000_000_009;
    }
}
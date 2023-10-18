import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, price;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            price = Integer.parseInt(br.readLine());
            sb.append(makeCoins()).append("\n");
        }
        System.out.print(sb);
    }
    private static int makeCoins() {
        int[] dp = new int[10001];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = coins[i]; j <= price; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[price];
    }
}
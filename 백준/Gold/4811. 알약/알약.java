import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[31];

        dp[0] = 1;
        for (int i = 1; i <= 30; i++) {
            dp[i] = 2 * (2 * i + 1) * dp[i-1] / (i + 2);
        }

        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) break;
            sb.append(dp[x-1]).append("\n");
        }

        System.out.println(sb);
    }
}
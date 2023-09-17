import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[65][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1; // 한자리수는 모두 1개씩 있음.
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            long result = 0;
            for (int i=0; i<=9; i++) {
                result += dp[x][i];
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
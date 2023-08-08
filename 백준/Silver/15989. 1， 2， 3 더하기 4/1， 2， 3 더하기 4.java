import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[10001][4];
        dp[1][1] = 1; // 1 만드는 수식, 오름 차순 정렬 후 마지막으로 더한 수 1 (1)
        dp[2][1] = 1; // 2 만드는 수식, 오름 차순 정렬 후 마지막으로 더한 수 1 (1 + 1)
        dp[2][2] = 1; // 2 만드는 수식, 오름 차순 정렬 후 마지막으로 더한 수 2 (2)
        dp[3][1] = 1; // 3 만드는 수식, 오름 차순 정렬 후 마지막으로 더한 수 1 (1 + 1 + 1)
        dp[3][2] = 1; // 3 만드는 수식, 오름 차순 정렬 후 마지막으로 더한 수 2 (1 + 2)
        dp[3][3] = 1; // 3 만드는 수식, 오름 차순 정렬 후 마지막으로 더한 수 3 (3)

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x][1] + dp[x][2] + dp[x][3]).append("\n");
        }

        System.out.println(sb);
    }

}
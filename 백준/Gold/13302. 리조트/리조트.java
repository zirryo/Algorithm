import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static final int MAX = 37 * 100;
    static boolean[] emptied;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
        }
        emptied = new boolean[N + 1];
        dp = new int[N + 1][N];
        for (int i = 0; i < M; i++) {
            int day = Integer.parseInt(st.nextToken());
            emptied[day] = true;
        }

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], MAX);
        }
        System.out.println(resort(1, 0) * 1000);
    }
    private static int resort (int day, int coupon) {
        if (day > N) return 0;
        if (dp[day][coupon] != MAX) return dp[day][coupon];
        if (emptied[day]) {
            return dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 1, coupon));
        } else {
            if (coupon >= 3) {
                dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 1, coupon - 3));
            }
            dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 1, coupon) + 10);
            dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 3, coupon + 1) + 25);
            dp[day][coupon] = Math.min(dp[day][coupon], resort(day + 5, coupon + 2) + 37);
            return dp[day][coupon];
        }
    }
}
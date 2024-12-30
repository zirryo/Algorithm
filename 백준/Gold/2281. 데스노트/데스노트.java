import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] nameLen;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nameLen = new int[n];
        for (int i = 0; i < n; i++) {
            nameLen[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n][m+2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(1, nameLen[0] + 1));
    }
    static int solve(int idx, int len) {
        if (idx == n) return 0;

        int res = dp[idx][len];
        if (res != -1) return res;

        res = (m - len + 1) * (m - len + 1) + solve(idx + 1, nameLen[idx] + 1);

        if (len + nameLen[idx] <= m) {
            res = Math.min(res, solve(idx + 1, len + nameLen[idx] + 1));
        }

        return dp[idx][len] = res;
    }
}

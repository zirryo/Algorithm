import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] left, right;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        left = new int[N];
        right = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) left[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) right[i] = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, 0));
    }

    static int solve(int L, int R) {
        if (L == N || R == N) return 0;
        if (dp[L][R] != -1) return dp[L][R];

        int res = Math.max(solve(L + 1, R), solve(L + 1, R + 1));

        if (right[R] < left[L]) {
            res = Math.max(res, solve(L, R + 1) + right[R]);
        }

        return dp[L][R] = res;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX = 1000 * 1000;
        int N = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();
        char[] boj = {'B', 'O', 'J', 'B'};
        int[] dp = new int[N];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = i+1; k < N; k++) {
                    if (map[i] == boj[j] && map[k] == boj[j+1]) {
                        dp[k] = Math.min(dp[k], dp[i] + (k-i) * (k-i));
                    }
                }
            }
        }

        if (dp[N-1] == MAX) System.out.println(-1);
        else System.out.println(dp[N-1]);
    }
}
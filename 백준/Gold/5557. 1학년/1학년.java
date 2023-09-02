import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[][] dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]]++;

        for (int i = 1; i < N-1; i++) {
            int x = arr[i];
            for (int j = 0; j <= 20; j++) {
                if (j - x >= 0) dp[i][j] += dp[i-1][j-x];
                if (j + x <= 20) dp[i][j] += dp[i-1][j+x];
            }
        }

        System.out.println(dp[N-2][arr[N-1]]);
    }
}
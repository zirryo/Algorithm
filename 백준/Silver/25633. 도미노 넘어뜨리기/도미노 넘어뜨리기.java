import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i; j > 0; j--) {
                if (dp[j - 1] == 0) continue;
                if (dp[j - 1] >= arr[i]) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + arr[i]);
                }
            }
            dp[1] = Math.max(dp[1], arr[i]);
        }

        for (int i = N; i > 0; i--) {
            if (dp[i] != 0) {
                System.out.println(i);
                break;
            }
        }
    }
}

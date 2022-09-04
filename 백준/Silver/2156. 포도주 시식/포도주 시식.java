import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        Arrays.fill(dp, -1);

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1]; // N == 1

        if(N > 1) dp[2] = arr[1] + arr[2]; // N == 2
        System.out.println(recursive(N));

    }

    static int recursive(int N) {
        if(dp[N] < 0 && N > 2) {
            dp[N] = Math.max(Math.max(recursive(N-3) + arr[N-1], recursive(N-2)) + arr[N], recursive(N-1));
        }
        return dp[N];
    }
}

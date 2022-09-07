import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(N>=2) dp[2] = arr[2] + arr[1];
        System.out.println(step(N));

    }
    static int step(int N) {
        if(dp[N]==0 && N>1) dp[N] = Math.max(step(N-3) + arr[N-1], step(N-2)) + arr[N];
        return dp[N];
    }
}
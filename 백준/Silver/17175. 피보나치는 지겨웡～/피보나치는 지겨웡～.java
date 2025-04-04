import java.io.*;

public class Main {
    static final int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2]; 
        
        dp[0] = 1; 
        dp[1] = 1; 

        for (int i = 2; i <= n; i++) {
            dp[i] = (int)(((long)dp[i - 1] + dp[i - 2] + 1) % MOD);
        }

        System.out.println(dp[n]);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int t = Integer.parseInt(st.nextToken()); 
        
        int[] dp = new int[t + 1]; 
        Arrays.fill(dp, -1); 
        dp[0] = 0; 
        
        for (int i = 0; i <= t; i++) {
            if (dp[i] == -1) continue;

            if (i + n <= t) dp[i + n] = Math.max(dp[i + n], dp[i] + 1);
            if (i + m <= t) dp[i + m] = Math.max(dp[i + m], dp[i] + 1);
        }

        int maxBurger = 0, colaTime = t;
        for (int i = t; i >= 0; i--) {
            if (dp[i] != -1) {
                maxBurger = dp[i]; 
                colaTime = t - i; 
                break;
            }
        }

        System.out.println(maxBurger + " " + colaTime);
    }
}

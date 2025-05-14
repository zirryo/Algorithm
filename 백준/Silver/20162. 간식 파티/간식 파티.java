import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] snack = new int[N];
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N]; 
        int maxSatisfaction = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = snack[i];
            for (int j = 0; j < i; j++) {
                if (snack[j] < snack[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + snack[i]);
                }
            }
            maxSatisfaction = Math.max(maxSatisfaction, dp[i]);
        }

        System.out.println(maxSatisfaction);
    }
}

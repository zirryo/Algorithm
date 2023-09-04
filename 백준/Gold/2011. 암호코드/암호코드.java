import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        int[] arr = new int[len+1];
        int[] dp = new int[len+1];


        for (int i = 1; i <= len; i++) {
            arr[i] = s.charAt(i-1) - '0';
        }
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (arr[i] > 0) {
                dp[i] = (dp[i] + dp[i-1]) % 1000000;
            }
            int num = arr[i-1] * 10 + arr[i];
            if (num >= 10 && num <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }
        }


        System.out.println(dp[len] % 1000000);
    }
}
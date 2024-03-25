import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = " " + br.readLine();
        int len = input.length();
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < len; i++) {
            if (input.charAt(i) != '0') dp[i] += dp[i-1];

            if (input.charAt(i-1) == '0') continue;
            int num = (input.charAt(i-1) - '0') * 10 + (input.charAt(i) - '0');
            if (num >= 1 && num <= 34) dp[i] += dp[i-2];
        }

        System.out.println(dp[len-1]);

    }
}
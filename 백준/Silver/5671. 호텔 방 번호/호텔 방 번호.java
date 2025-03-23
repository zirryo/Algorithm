import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 5000;
    private static final int[] dp = new int[MAX + 1];

    private static boolean hasUniqueDigits(int num) {
        boolean[] seen = new boolean[10];
        while (num > 0) {
            int digit = num % 10;
            if (seen[digit]) {
                return false;
            }
            seen[digit] = true;
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= MAX; i++) {
            dp[i] = dp[i - 1] + (hasUniqueDigits(i) ? 1 : 0);
        }

        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M] - dp[N - 1]).append('\n');
        }

        System.out.print(sb);
    }
}

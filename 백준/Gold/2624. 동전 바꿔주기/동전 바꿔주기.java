import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] dp = new int[T+1];
        dp[0] = 1;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int coinVal = Integer.parseInt(st.nextToken());
            int coinCnt = Integer.parseInt(st.nextToken());

            for (int j = T; j >= 0; j--) {
                for (int c = 1; c <= coinCnt; c++) {
                    if (j >= coinVal * c) {
                        dp[j] += dp[j - coinVal * c];
                    }
                }
            }
        }

        System.out.println(dp[T]);

    }
}

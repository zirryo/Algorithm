import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] dp = new int[H + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> blocks = new ArrayList<>();
            while (st.hasMoreTokens()) {
                blocks.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = H; j > 0; j--) {
                for (int block : blocks) {
                    if (j - block >= 0) {
                        dp[j] = (dp[j - block] + dp[j]) % 10007;
                    }
                }
            }
        }

        System.out.println(dp[H]);
    }
}
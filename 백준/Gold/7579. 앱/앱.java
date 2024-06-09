import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N + 1];
        int[] cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int sumCost = 0;
        for (int i = 1; i <= N; i++) {
            sumCost += cost[i];
        }

        int[] dp = new int[sumCost + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= sumCost; i++) {
            if (dp[i] >= M) {
                result = Math.min(result, i);
            }
        }
        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int INF = 1_000_000_000;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = setTask(0, 0);
        System.out.println(result);
    }
    private static int setTask(int person, int task) {
        if (person == N) return 0;
        if (dp[person][task] != 0) return dp[person][task];

        int val = INF;
        for (int i = 0; i < N; i++) {
            if ((task & (1 << i)) == 0) {
                val = Math.min(val, cost[person][i] + setTask(person + 1, task | (1 << i)));
            }
        }

        dp[person][task] = val;
        return dp[person][task];
    }
}
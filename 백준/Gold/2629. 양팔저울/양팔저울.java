import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int maxWeight;
    static int[] weight;
    static int[] marble;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        init();
        dfs(0, 0);

        for (int i = 0; i < M; i++) {
            if (marble[i] > maxWeight)
                sb.append("N "); // 모든 추를 다 사용해도 무게를 측정할 수 없는 경우
            if (dp[N][marble[i]]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());
        maxWeight = 0;

        weight = new int[N+1];
        for (int i=1; i<=N; i++)
            weight[i] = Integer.parseInt(st.nextToken());

        marble = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            marble[i] = Integer.parseInt(st.nextToken());
            maxWeight += marble[i];
        }
        dp = new boolean[31][40001];
    }

    private static void dfs(int idx, int wei) {
        if (dp[idx][wei]) return; // 특정 무게를 만들 수 있음
        dp[idx][wei] = true;
        if (idx == N) return; // 모든 추를 다 사용한 경우

        dfs(idx+1, wei + weight[idx+1]); // 다음 추를 더 올리는 경우
        dfs(idx+1, wei); // 추를 더 올리지 않는 경우
        dfs(idx+1, Math.abs(wei - weight[idx+1])); // 추를 빼는 경우
    }
}
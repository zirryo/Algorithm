import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] dp;
    static ArrayList<Airplane>[] list;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dp = new int[M+1][N+1]; // m번째 도시로 n을 방문했을 때의 최댓값

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(s >= e) continue;
            list[s].add(new Airplane(e, w));
        }
    }
    private static int bfs() {
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty() && cnt < M) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for(Airplane a : list[cur]) {
                    int next = a.e;
                    int point = a.w + dp[cnt][cur];
                    if(dp[cnt+1][next] >= point) continue; // 이미 더 높은 점수로 해당 위치에 도달했다면 스킵
                    dp[cnt+1][next] = point;
                    q.add(next);
                }
            }
            cnt++;
        }

        int result = 0;
        for(int i=2; i<=M; i++) {
            result = Math.max(result, dp[i][N]);
        }
        return result;
    }
    static class Airplane {
        int e;
        int w;

        public Airplane(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}
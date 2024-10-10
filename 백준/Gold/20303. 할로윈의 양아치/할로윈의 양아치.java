import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] candy;
    static List<Integer> sizeList = new ArrayList<>();
    static List<Integer> totalCandyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        visited = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int[] temp = bfs(i);
                sizeList.add(temp[0]);
                totalCandyList.add(temp[1]);
            }
        }

        int[] dp = new int[K];
        for (int i = 0; i < sizeList.size(); i++) {
            int groupSize = sizeList.get(i);
            int groupCandy = totalCandyList.get(i);

            for (int j = K - 1; j >= groupSize; j--) {
                dp[j] = Math.max(dp[j], groupCandy + dp[j - groupSize]);
            }
        }

        int result = Arrays.stream(dp).max().orElse(0);
        System.out.println(result);
    }

    static int[] bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        int size = 0;
        int totalCandy = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            size++;
            totalCandy += candy[cur];

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return new int[]{size, totalCandy};
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] depth = new int[N+1];
        Arrays.fill(depth, -1);
        depth[R] = 0;
        queue.add(R);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int curDepth = depth[u];
            for (int v : graph[u]) {
                if (depth[v] != -1) continue;
                depth[v] = curDepth + 1;
                queue.add(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);

    }
}
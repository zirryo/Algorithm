import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean hasCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph.get(A).add(B);
                graph.get(B).add(A);
            }

            if (M != N - 1) {
                sb.append("graph\n");
                continue;
            }

            visited = new boolean[N + 1];
            hasCycle = false;

            dfs(1, -1);

            boolean connected = true;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    connected = false;
                    break;
                }
            }

            if (!hasCycle && connected) {
                sb.append("tree\n");
            } else {
                sb.append("graph\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int node, int parent) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, node);
            } else if (next != parent) {
                hasCycle = true;
            }
        }
    }
}

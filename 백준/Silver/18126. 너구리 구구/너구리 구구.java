import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        long w;
        Edge(int to, long w) { this.to = to; this.w = w; }
    }

    static int N;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static long maxDist = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            adj[A].add(new Edge(B, C));
            adj[B].add(new Edge(A, C));
        }

        visited = new boolean[N + 1];
        dfs(1, 0L);

        System.out.println(maxDist);
    }

    static void dfs(int u, long dist) {
        visited[u] = true;
        if (dist > maxDist) maxDist = dist;

        for (Edge e : adj[u]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.w);
            }
        }
    }
}

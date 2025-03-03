import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<Integer>[] graph, reverseGraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);       
            reverseGraph[B].add(A); 
        }

        int higher = bfs(reverseGraph, X);
        int lower = bfs(graph, X);

        int U = higher + 1;
        int V = N - lower;

        System.out.println(U + " " + V);
    }

    static int bfs(List<Integer>[] g, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : g[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}

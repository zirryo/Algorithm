import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v, w;
        Node(int v, int w) { this.v = v; this.w = w; }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int farNode, maxDist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int maxNode = 10000;
        graph = new ArrayList[maxNode + 1];
        for (int i = 1; i <= maxNode; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean hasInput = false;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            hasInput = true;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        if (!hasInput) {
            System.out.println(0);
            return;
        }

        visited = new boolean[maxNode + 1];
        maxDist = -1;
        dfs(1, 0);
        
        visited = new boolean[maxNode + 1];
        maxDist = -1;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int cur, int dist) {
        visited[cur] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = cur;
        }

        for (Node nxt : graph[cur]) {
            if (!visited[nxt.v]) {
                dfs(nxt.v, dist + nxt.w);
            }
        }
    }
}

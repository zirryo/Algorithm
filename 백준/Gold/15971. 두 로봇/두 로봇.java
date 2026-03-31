import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int target, weight;
        Node(int next, int cost) {
            this.target = next;
            this.weight = cost;
        }
    }

    static List<Node>[] caveMap;
    static boolean[] visited;
    static int endNode;
    static long totalDist = 0;
    static int maxEdge = 0;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int room1 = Integer.parseInt(st.nextToken());
        int room2 = Integer.parseInt(st.nextToken());

        if (room1 == room2) {
            System.out.println(0);
            return;
        }

        caveMap = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) caveMap[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            caveMap[u].add(new Node(v, w));
            caveMap[v].add(new Node(u, w));
        }

        visited = new boolean[N + 1];
        endNode = room2;

        dfs(room1, 0, 0);

        System.out.println(totalDist - maxEdge);
    }

    static void dfs(int current, long sum, int max) {
        if (current == endNode) {
            totalDist = sum;
            maxEdge = max;
            found = true;
            return;
        }

        visited[current] = true;
        for (Node next : caveMap[current]) {
            if (!visited[next.target]) {
                dfs(next.target, sum + next.weight, Math.max(max, next.weight));
                if (found) return;
            }
        }
    }
}
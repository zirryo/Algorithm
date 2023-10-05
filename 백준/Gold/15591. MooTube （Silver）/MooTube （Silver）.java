import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph.get(p).add(new Node(q, r));
            graph.get(q).add(new Node(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(mooTube(k, v)).append("\n");
        }
        System.out.print(sb);
    }
    private static int mooTube(int k, int v) {
        boolean[] visited = new boolean[N+1];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node next : graph.get(cur)) {
                int end = next.end;
                int wei = next.weight;

                if (wei >= k && !visited[end]) {
                    q.add(end);
                    visited[end] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
class Node {
    int end;
    int weight;

    public Node(int e, int w) {
        this.end = e;
        this.weight = w;
    }
}
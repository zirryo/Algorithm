import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return o.w - this.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            pq.add(new Edge(u, target, width));
        }

        parent = new int[p];
        for (int i = 0; i < p; i++) parent[i] = i;

        int result = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            union(edge.u, edge.v);

            if (find(c) == find(v)) {
                result = edge.w;
                break;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}
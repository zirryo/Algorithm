import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        init();
        int minCost = solve();
        System.out.println(minCost);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        parent = new int[V+1];

        for(int i=1; i<=V; i++) parent[i] = i;

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(s, e, w));
        }
    }
    
    private static int solve() {
        int result = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            int a = find(cur.start);
            int b = find(cur.end);

            if(a == b) continue;

            result += cur.cost;
            union(cur.start, cur.end);
        }
        return result;
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) parent[bRoot] = aRoot;
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        // weight 를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static double result = 0.0;
    static God[] gods;
    static int[] parent;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gods = new God[N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++) {
            parent[i] = i;

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gods[i] = new God(x, y);
        }
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            union(s, e);
        }
        makeEdges();
        System.out.printf("%.2f",result);
    }
    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }
    private static void makeEdges() {
        pq = new PriorityQueue<>();

        for(int i=1; i<N; i++) {
            for(int j=i+1; j<=N; j++) {
                pq.add(new Edge(i, j, getDist(gods[i], gods[j])));
            }
        }

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(union(cur.start, cur.end)) result += cur.dist;
        }
    }
    private static double getDist(God s1, God s2) {
        return Math.sqrt(Math.pow(Math.abs(s2.x-s1.x), 2) + Math.pow(Math.abs(s2.y-s1.y), 2));
    }
    private static class God {
        int x;
        int y;

        public God(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double dist;

        public Edge(int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge edge) {
            double cal = this.dist - edge.dist;
            return cal >= 0.0 ? 1 : -1;
        }
    }
}
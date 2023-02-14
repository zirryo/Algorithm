import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static Star[] stars;
    static PriorityQueue<Edge> pq;
    
    public static void main(String[] args) throws IOException {
        init();
        makeEdges();

        double result = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            int s = find(cur.start);
            int e = find(cur.end);

            if (s==e) continue;

            result += cur.dist;
            union(cur.start, cur.end);
        }
        System.out.printf("%.2f", result);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stars = new Star[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i] = new Star(x, y);
        }

        parent = new int[N+1];
        for(int i=1; i<N; i++) parent[i] = i;
    }
    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parent[rootB] = rootA;
    }
    private static void makeEdges() {
        pq = new PriorityQueue<>();

        for(int i=1; i<N; i++) {
            for(int j=i+1; j<=N; j++) {
                if(i==j) continue;
                pq.add(new Edge(i, j, getDist(stars[i], stars[j])));
            }
        }
    }
    private static double getDist(Star s1, Star s2) {
        return Math.sqrt(Math.pow(Math.abs(s2.x-s1.x), 2) + Math.pow(Math.abs(s2.y-s1.y), 2));
    }
    
    private static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class Edge implements Comparable<Edge> {
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
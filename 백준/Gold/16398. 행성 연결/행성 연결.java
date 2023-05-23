import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static int[][] arr;
    static long result = 0;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        arr = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i != j) pq.add(new Edge(i, j, arr[i][j]));
            }
        }

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int a = find(cur.s);
            int b = find(cur.e);
            if (a == b) continue;
            union(a, b);
            result += cur.w;
        }
        System.out.println(result);
    }
    private static int find(int x) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) parent[aRoot] = b;
    }
    private static class Edge implements Comparable<Edge> {

        int s;
        int e;
        int w;

        public Edge(int start, int end, int weight) {
            this.s = start;
            this.e = end;
            this.w = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
}
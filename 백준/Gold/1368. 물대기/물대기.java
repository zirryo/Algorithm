import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static int[] W, root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N+1];
        root = new int[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i=1; i<=N; i++) {
            W[i] = Integer.parseInt(br.readLine());
            root[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (i == j) pq.add(new Edge(0, i, W[i]));
                else if (i < j) pq.add(new Edge(i, j, x));
            }
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.s) == find(cur.e)) continue;
            union(cur.s, cur.e);
            result += cur.w;
        }
        System.out.println(result);

    }
    private static int find(int x) {
        if (x == root[x]) return x;
        else return root[x] = find(root[x]);
    }
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) root[aRoot] = b;
    }
}
class Edge implements Comparable<Edge> {
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.w - edge.w;
    }
}
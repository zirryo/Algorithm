import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, connected;
    static long total, use;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        total = 0;
        use = 0;
        connected = 0;
        root = new int[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) root[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += c;
            pq.add(new Edge(a, b, c));
        }

        while (!pq.isEmpty()) {
            if (connected == N - 1) break;
            Edge cur = pq.poll();
            if (find(cur.s) == find(cur.e)) continue;
            union(cur.s, cur.e);
            use += cur.w;
            connected++;
        }

        if (connected == N - 1) System.out.println(total - use);
        else System.out.println("-1");
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
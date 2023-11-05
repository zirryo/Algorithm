import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N, total = 0, use = 0, cnt = 0;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        root = new int[N+1];
        for (int i=1; i<=N; i++) root[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);

                if (c >= 'a' && c <= 'z') {
                    pq.add(new Edge(i+1, j+1, c - 96));
                    total += (c - 96);
                }
                else if (c >= 'A' && c <= 'Z') {
                    pq.add(new Edge(i+1, j+1, c - 38));
                    total += (c - 38);
                }
            }
        }

        while (!pq.isEmpty()) {
            if (cnt == N - 1) break;
            Edge cur = pq.poll();
            if (cur.s == cur.e || find(cur.s) == find(cur.e)) continue;
            union(cur.s, cur.e);
            use += cur.w;
            cnt++;
        }

        if (cnt == N - 1) System.out.println(total - use);
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
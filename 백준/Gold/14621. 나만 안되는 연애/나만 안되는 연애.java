import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] parent;
    static boolean[] gender;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        gender = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            String s = st.nextToken();
            if (s.equals("M")) {
                gender[i] = true;
            } else {
                gender[i] = false;
            }
        }

        pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (gender[s] != gender[e]) {
                pq.add(new Edge(s, e, d));
            }
        }
        int result = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int a = find(cur.start);
            int b = find(cur.end);

            if (a == b) continue;

            result += cur.dist;
            union(a, b);
        }
        if (connectCheck()) System.out.println(result);
        else System.out.println(-1);
    }
    private static boolean connectCheck() {
        int root = 0;
        for (int i=1; i<=N; i++) {
            find(i);

            if (root == 0) root = parent[i];
            else if(root != parent[i]) {
                return false;
            }
        }
        return true;
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
    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.dist - edge.dist;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            
            parent = new int[N];
            pq = new PriorityQueue<>();
            for(int i=0; i<N; i++) parent[i] = i;
            int total = 0;
            
            while(M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                pq.add(new Edge(x, y, z));
                total += z;
            }
            int save = total - makeMST();
            sb.append(save).append("\n");
        }
        System.out.println(sb);
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
    private static int makeMST() {
        int savedCost = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(union(cur.s, cur.e)) savedCost += cur.w;
        }
        return savedCost;
    }
    private static class Edge implements Comparable<Edge> {
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
}
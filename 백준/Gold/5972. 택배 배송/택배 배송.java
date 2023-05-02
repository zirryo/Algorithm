import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] list;
    static int[] cost;
    static final int INF = 50000*1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        Arrays.fill(cost, INF);
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[s].add(new Edge(e, v));
            list[e].add(new Edge(s, v));
        }
        dijkstra(1);
        System.out.println(cost[N]);
    }
    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for(Edge next : list[cur.end]) {
                if(cost[next.end] > cur.val + next.val) {
                    cost[next.end] = cur.val + next.val;
                    pq.add(new Edge(next.end, cost[next.end]));
                }
            }
        }
    }
    private static class Edge implements Comparable<Edge> {
        int end;
        int val;

        public Edge(int end, int val) {
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Edge e) {
            return this.val - e.val;
        }
    }
}
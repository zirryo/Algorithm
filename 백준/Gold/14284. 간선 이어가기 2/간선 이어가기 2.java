import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] list;
    static int[] cost;
    static final int INF = 100000*100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        Arrays.fill(cost, INF);
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        dijkstra(S, T);
        System.out.println(cost[T]);
    }
    private static void dijkstra(int start, int end) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.e]) continue;
            visited[cur.e] = true;
            for(Edge next : list[cur.e]) {
                if(cost[next.e] > cost[cur.e] + next.val) {
                    cost[next.e] = cost[cur.e] + next.val;
                    pq.add(new Edge(next.e, cost[next.e]));
                }
            }
        }
    }
    private static class Edge implements Comparable<Edge> {
        int e;
        int val;

        public Edge(int e, int val) {
            this.e = e;
            this.val = val;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.val - edge.val;
        }
    }
}
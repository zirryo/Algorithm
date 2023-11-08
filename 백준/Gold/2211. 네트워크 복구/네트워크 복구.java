import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] networks;
    static int[] connected;
    static int[] costToSuper;
    static final int INF = 1000 * 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        costToSuper = new int[N+1];
        Arrays.fill(costToSuper, INF);
        networks = new ArrayList[N+1];
        connected = new int[N+1];
        for (int i=0; i<=N; i++) networks[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            networks[a].add(new Edge(b, c));
            networks[b].add(new Edge(a, c));
        }
        dijkstra(1);
        sb.append(N-1).append("\n");
        for (int i = 2; i <= N; i++) {
            sb.append(i).append(" ").append(connected[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void dijkstra(int startNode) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startNode, 0));
        costToSuper[startNode] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Edge next : networks[cur.end]) {
                if (costToSuper[next.end] > costToSuper[cur.end] + next.cost) {
                    costToSuper[next.end] = costToSuper[cur.end] + next.cost;
                    pq.add(new Edge(next.end, costToSuper[next.end]));
                    connected[next.end] = cur.end;
                }
            }
        }
    }
    private static class Edge implements Comparable<Edge> {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.end - edge.end;
        }
    }
}
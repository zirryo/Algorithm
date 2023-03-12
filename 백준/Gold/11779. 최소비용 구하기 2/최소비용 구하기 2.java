import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, start, end, cities = 0;
    static int INF = 1000 * 100000;
    static int[] dist;
    static boolean[] visited;
    static int[] path;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        dijkstra(start);
        sb.append(dist[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while(true) {
            stack.push(path[end]);
            end = path[end];
            if(end == start) break;
        }
        while (!stack.isEmpty()) {
            cities++;
            sb2.append(stack.pop()).append(" ");
        }
        sb.append(cities);
        System.out.println(sb + "\n" + sb2);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        visited = new boolean[N+1];
        path = new int[N+1];
        edges = new ArrayList[N+1];

        Arrays.fill(dist, INF);
        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[s].add(new Edge(e, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            for(Edge next : edges[cur.e]) {
                if(dist[cur.e] + next.w < dist[next.e]) {
                    dist[next.e] = dist[cur.e] + next.w;
                    path[next.e] = cur.e;
                    pq.add(new Edge(next.e, dist[next.e]));
                }
            }
        }
    }
    private static class Edge implements Comparable<Edge> {
        int e;
        int w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
}
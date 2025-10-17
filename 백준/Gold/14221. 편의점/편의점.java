import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] houses = new int[h];
        int[] stores = new int[s];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < h; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            stores[i] = Integer.parseInt(st.nextToken());
        }

        dijkstra(stores);

        int min = INF;
        int result = -1;

        Arrays.sort(houses);

        for (int ho : houses) {
            if (dist[ho] < min) {
                min = dist[ho];
                result = ho;
            }
        }

        System.out.println(result);

    }

    static void dijkstra(int[] stores) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int s : stores) {
            dist[s] = 0;
            pq.add(new Node(s, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (dist[cur.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, P;
    static ArrayList<Edge>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점수
        E = Integer.parseInt(st.nextToken()); // 간선수
        P = Integer.parseInt(st.nextToken()); // 건우의 위치
        list = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        if (getShortestDist(1, V) >= getShortestDist(1, P) + getShortestDist(P, V)) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }
    private static int getShortestDist(int start, int end) {
        final int INF = 5000 * 10000;
        Queue<Edge> q = new LinkedList<>();
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);

        q.add(new Edge(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            for (Edge next : list[cur.e]) {
                if (dist[next.e] > dist[cur.e] + next.w) {
                    dist[next.e] = dist[cur.e] + next.w;
                    q.add(new Edge(next.e, dist[next.e]));
                }
            }
        }
        return dist[end];
    }
}
class Edge implements Comparable<Edge> {
    int e;
    int w;

    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo (Edge edge) {
        return this.w - edge.w;
    }
}
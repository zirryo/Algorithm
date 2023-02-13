import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static ArrayList<Edge>[] edges;
    public static void main(String[] args) throws IOException {
        init();
        prim();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[V+1];
        for(int i=0; i<=V; i++) edges[i] = new ArrayList<>();

        while(E-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[s].add(new Edge(e, c));
            edges[e].add(new Edge(s, c));
        }
    }
    private static void prim() { // 프림 알고리즘 ( 시간복잡도 ElogV , 간선이 많은 MST 에서 유리함)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        int sum = 0; // 유지비의 합
        int max = 0; // MST 에 포함되는 간선 중 가장 높은 cost

        pq.add(new Edge(1, 0)); // 임의의 정점에서 시

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(visited[cur.end]) continue;
            visited[cur.end] = true;

            sum += cur.cost;
            max = Math.max(max, cur.cost);

            for(Edge edge : edges[cur.end]) {
                if(!visited[edge.end]) pq.add(edge);
            }
        }
        System.out.println(sum - max);
    }
    public static class Edge implements Comparable<Edge> {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
}
/* Prim - MST Algorithm
임의의 시작점에서 연결되지 않은 정점들에 대해, 가장 가중치가 작은 정점을 연결하는 방식.
핵심은 트리 집합을 단계적으로 확장하는 것. 모든 정점이 연결되면 동작 종료.
새로운 정점을 연결할 때마다 새로운 정점에서 갈 수 있는 아직 연결되지 않은 정점들에 대한 간선을 추가함.
Priority Queue를 이용한 최소 힙으로 구현할 수 있고, 다익스트라 알고리즘과 구현 방식이 유사함.
 */
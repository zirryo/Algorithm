import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int INF = 10000 * 6000 + 1;
    static long[] dist; // range : - 10000 * 6000 * 500 ~ 10000 * 6000 * 500
    static ArrayList<Edge>[] edges;
    
    public static void main(String[] args) throws IOException {
        init();

        boolean infiniteCycle = bellmanFord(1);

        if(infiniteCycle) System.out.println(-1); // 시간을 무한히 되돌릴 수 있는 경우
        else {
            for(int i=2; i<=N; i++) {
                if(dist[i] == INF) System.out.println(-1); // 해당 도시로 가는 경로 없는 경우
                else System.out.println(dist[i]);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N+1];
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
    }

    private static boolean bellmanFord(int startNode) {
        dist[startNode] = 0; // 시작 노드 == 1

        for(int i=1; i<N; i++) { // 시작점을 제외한 노드의 수 == N-1
            for(int j=1; j<=N; j++) {
                for(Edge next : edges[j]) { // 현재 노드의 모든 인접 노드 탐색 (j에서 출발하는 버스 탐색)
                    if(dist[j] != INF && dist[next.e] > dist[j] + next.w) {
                        dist[next.e] = dist[j] + next.w; // 경유하는 것이 더 가까울 경우 갱신
                    }
                }
            }
        }
        // 최단 경로를 구한 후, 또 갱신이 일어나는 경우 -> 마이너스 무한 사이클 존재
        for(int i=1; i<N; i++) {
            for(Edge next : edges[i]) {
                if(dist[i] != INF && dist[next.e] > dist[i] + next.w) {
                    return true;
                }
            }
        }
        return false;
    }
}
class Edge {
    int e; // 도착지
    int w; // 가중치

    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }
}

/* 벨만 포드 알고리즘
- 한 노드에서 다른 노드까지의 최단 거리를 구하는 알고리즘으로 간선의 가중치가 음수일 때도 사용할 수 있음.
- 매 단계마다 모든 간선을 전부 확인하면서 모든 노드간의 최단 거리를 구하는 알고리즘
- 시간 복잡도 : 최악의 경우 O(V^3) (다익스트라 알고리즘은 최악의 경우 O(V^2))
- 따라서 간선의 가중치에 음수가 존재하지 않는 경우에는 다익스트라 알고리즘을 채택하는 것이 유리함.

< 동작 >
1. 시작 노드 지정
2. 시작 노드에서 각 다른 노드의 거리 값 무한대로 설정하고, 시작 노드는 0으로 설정함
3. 현재 노드의 모든 인접 노드 탐색 -> 현재 노드를 경유하는 것이 더 가까울 경우 갱신
4. 3의 과정을 모든 노드에 대하여 수행함
5. 모든 노드에 3 - 4를 수행하고서 또 거리가 갱신된다면 음수 무한 사이클이 존재하는 것을 알 수 있음
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    // 우선순위 큐를 활용하여 가중치(w) 오름차순으로 정렬하기 위해 메서드 오버라이딩
    @Override
    public int compareTo(Node node) {
        return this.w - node.w;
    }
}

public class Main {
    static ArrayList<Node>[] list;
    static int N, E;
    static int v1, v2;
    static int[] dis;
    static boolean[] isVisited;
    static final int INF = 200000 * 1000; // 최대 간선 수 * 최대 거리

//  way1: 1 -> v1 -> v2 -> N
//  way2: 1 -> v2 -> v1 -> N
//  최단거리를 다익스트라를 이용하여 구현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        dis = new int[N+1];
        isVisited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        System.out.println(getDistance());

    }

    private static int getDistance() {
        int way1 = 0;
        int way2 = 0;

        int common = dijkstra(v1, v2); // == dijkstra(v2, v1)

        way1 = dijkstra(1, v1) + common + dijkstra(v2, N);
        way2 = dijkstra(1, v2) + common + dijkstra(v1, N);

        if(way1 >= INF && way2 >= INF) return -1; // 경로 없음
        return Math.min(way1, way2);
    }

    private static int dijkstra(int s, int e) {
        Arrays.fill(dis, INF);
        Arrays.fill(isVisited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dis[s] = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int point = n.e;
            int weight = n.w;

            if(isVisited[point]) continue;
            isVisited[point] = true;

            for(int i=0; i<list[point].size(); i++) {
                int next = list[point].get(i).e;
                int nextWeight = list[point].get(i).w;

                if(!isVisited[next] && dis[next] > weight + nextWeight) {
                    dis[next] = weight + nextWeight;
                    pq.add(new Node(next, dis[next]));
                }
            }
        }

        return dis[e];
    }

}
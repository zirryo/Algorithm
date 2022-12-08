import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] list; // 리스트의 인덱스 == 간선의 시작점
    static int[] minW;
    static final int INF = 2000000; // 최대 가중치 * 최대 정점 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];

        for(int i=1; i<=V; i++) list[i] = new ArrayList<>();

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        minW = new int[V+1]; // 각 정점까지의 최단거리 저장
        Arrays.fill(minW, INF);
        minW[K] = 0;

        dijkstra(K);

        for(int i=1; i<=V; i++) {
            if(minW[i] == INF) sb.append("INF\n");
            else sb.append(minW[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int k) { // 데이크스트라 알고리즘 사용 (한 정점으로 부터 모든 정점으로의 최단거리)
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 메모리 + 시간단축 + 최솟값을 구하기 위해 우선순위큐 사용
        pq.add(new Node(k, 0));

        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            int edges = list[temp.i].size();

            for(int j=0; j<edges; j++) {
                Node post = list[temp.i].get(j);

                if(minW[post.i] > temp.v + post.v) { // 경유하는 것이 더 가중치가 적다면 최단거리 값 갱신
                    minW[post.i] = temp.v + post.v;
                    pq.add(new Node(post.i, minW[post.i]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int i; // 정점
        int v; // 가중치

        public Node(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Node n) {
            return this.v - n.v;
        }
    }

}
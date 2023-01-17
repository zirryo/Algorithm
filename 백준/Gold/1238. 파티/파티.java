import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static final int INF = 1000 * 100;
    static ArrayList<Node>[] fromHome; // 간선 정보를 뒤집어서 저장 (집 - 파티장 다익스트라 구현)
    static ArrayList<Node>[] toHome; // 간선 정보를 원래대로 저장 (파티장 - 집 다익스트라 구현)
    static int[] fromCost;
    static int[] toCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        fromHome = new ArrayList[N+1];
        toHome = new ArrayList[N+1];
        fromCost = new int[N+1];
        toCost = new int[N+1];

        for(int i=0; i<=N; i++) {
            fromHome[i] = new ArrayList<>();
            toHome[i] = new ArrayList<>();
            Arrays.fill(fromCost, INF);
            Arrays.fill(toCost, INF);
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            fromHome[e].add(new Node(s, w));
            toHome[s].add(new Node(e, w));
        }

        dijkstra(fromHome, fromCost);
        dijkstra(toHome, toCost);
        System.out.println(getMax(fromCost, toCost));
    }

    static void dijkstra(ArrayList<Node>[] lists, int[] cost) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0)); // 파티장

        boolean[] visited = new boolean[N+1];
        cost[X] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.e]) {
                visited[cur.e] = true;

                for(Node next : lists[cur.e]) {
                    if(cost[next.e] > next.w + cost[cur.e]) {
                        cost[next.e] = next.w + cost[cur.e];
                        pq.add(new Node(next.e, cost[next.e]));
                    }
                }
            }

        }
    }

    static int getMax(int[] arr1, int[] arr2) {
        int max = 0;

        for(int i=1; i<=N; i++) {
            if(i == X) continue;
            max = Math.max(arr1[i] + arr2[i], max);
        }
        return max;
    }
}
class Node implements Comparable<Node> {
    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    public int compareTo(Node n) {
        return this.w - n.w;
    }
}
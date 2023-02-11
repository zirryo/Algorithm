import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100_000 * 1000;
    static int n, d, c;
    static int[] dist;
    static ArrayList<Edge>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 수 (1 ≤ n ≤ 10,000)
            d = Integer.parseInt(st.nextToken()); // 간선 수 (1 ≤ d ≤ 100,000)
            c = Integer.parseInt(st.nextToken()); // 해킹 시작점 (1 ≤ c ≤ n)

            dist = new int[n+1];
            list = new ArrayList[n+1];

            for(int i=0; i<=n; i++) { // 배열 초기화
                dist[i] = INF;
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken()); // 0 ≤ s ≤ 1,000
                list[b].add(new Edge(a, s)); // 컴퓨터 b가 감염 -> s초 후 a도 감염됨
            }
            dijkstra(c);
            infection();
        }
        System.out.println(sb);
    }
    private static void dijkstra(int startNode) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startNode, 0));
        dist[startNode] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curEnd = cur.end;
            int curCost = cur.cost;

            if(dist[curEnd] < curCost) continue; // 이미 더 적은 코스트로 감염이 가능하므로 스킵

            for(int i=0; i<list[curEnd].size(); i++) {
                int nextEnd = list[curEnd].get(i).end;
                int nextCost = list[curEnd].get(i).cost;

                if(dist[nextEnd] > nextCost + curCost) {
                    dist[nextEnd] = nextCost + curCost;
                    pq.add(new Edge(nextEnd, nextCost + curCost));
                }
            }
        }
    }
    private static void infection() {
        int computers = 0;
        int infectionTime = 0;

        for(int i=1; i<=n; i++) {
            if(dist[i] != INF) {
                computers++;
                infectionTime = Math.max(infectionTime, dist[i]);
            }
        }

        sb.append(computers + " " + infectionTime + "\n");
    }
    static class Edge implements Comparable<Edge> {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost; // cost 오름차순 정렬 (최소 코스트가 우선 순위)
        }
    }
}
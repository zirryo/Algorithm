import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, type;
        Edge(int to, int type) { this.to = to; this.type = type; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] subwayMap = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) subwayMap[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            subwayMap[u].add(new Edge(v, t));
            subwayMap[v].add(new Edge(u, t));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[][] insulation = new int[N + 1][2]; // insulation[역 번호][타입]
        for (int i = 1; i <= N; i++) Arrays.fill(insulation[i], 150000);

        Deque<int[]> deque = new ArrayDeque<>();

        for (Edge e : subwayMap[start]) {
            if (insulation[e.to][e.type] > 0) {
                insulation[e.to][e.type] = 0; // 시작점의 절연 횟수 == 0
                deque.addFirst(new int[]{e.to, e.type});
            }
        }

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int u = curr[0];
            int type = curr[1];

            if (u == end) {
                System.out.println(insulation[u][type]);
                return;
            }

            for (Edge next : subwayMap[u]) {
                int cost = (type == next.type) ? 0 : 1;
                if (insulation[next.to][next.type] > insulation[u][type] + cost) {
                    insulation[next.to][next.type] = insulation[u][type] + cost;
                    if (cost == 0) deque.addFirst(new int[]{next.to, next.type});
                    else deque.addLast(new int[]{next.to, next.type});
                }
            }
        }
    }
}
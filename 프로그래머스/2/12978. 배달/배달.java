import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; 

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.e;
            int weight = cur.w;

            if (weight > dist[now]) continue;

            for (Node next : graph[now]) {
                if (dist[next.e] > dist[now] + next.w) {
                    dist[next.e] = dist[now] + next.w;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }

        return count;
    }
}
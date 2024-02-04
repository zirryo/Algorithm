import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
          graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0));
        visited[a] = true;
        int result = -1;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.idx == b) {
                result = cur.cnt;
                break;
            }

            for (int next : graph[cur.idx]) {
                if (!visited[next]) {
                    pq.add(new Edge(next, cur.cnt + 1));
                    visited[next] = true;
                }
            }
        }

        System.out.println(result);
    }
    private static class Edge implements Comparable<Edge> {
        int idx;
        int cnt;

        public Edge(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cnt - e.cnt;
        }
    }
}
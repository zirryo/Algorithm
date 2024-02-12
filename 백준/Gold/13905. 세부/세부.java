import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, s, e, min, max;
    static ArrayList<Edge>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Edge(b, c));
            lists[b].add(new Edge(a, c));
            max = Math.max(max, c);
        }
        min = 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (bfs(mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
    private static boolean bfs(int pepero) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge edge : lists[cur]) {
                if (!visited[edge.next] && pepero <= edge.weight) {
                    visited[edge.next] = true;
                    q.add(edge.next);

                    if (edge.next == e) return true;
                }
            }
        }

        return false;
    }
    private static class Edge {
        int next;
        int weight;

        public Edge(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
}
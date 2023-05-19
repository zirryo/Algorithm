import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, v));
            list[e].add(new Edge(s, v));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(bfs(f, t)) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int bfs(int from, int to) {
        Queue<Edge> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int ans = 0;

        q.add(new Edge(from, 0));
        visited[from] = true;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (cur.e == to) {
                ans = cur.w;
                break;
            }

            for (Edge next : list[cur.e]) {
                if (visited[next.e]) continue;
                visited[next.e] = true;
                q.add(new Edge(next.e, cur.w + next.w));
            }
        }

        return ans;
    }
    private static class Edge {
        int e;
        int w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}
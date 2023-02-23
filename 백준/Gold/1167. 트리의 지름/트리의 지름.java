import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 0;
    static boolean[] visited;
    static ArrayList<Edge>[] edges;
    public static void main(String[] args) throws IOException {
        init();
        visited[1] = true;
        dfs(1); // 임의의 정점에서 시작
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int w = Integer.parseInt(st.nextToken());
                edges[s].add(new Edge(e, w));
            }
        }
    }
    private static int dfs(int x) {
        int val1 = 0;
        int val2 = 0;

        for(Edge next : edges[x]) {
            if(visited[next.e]) continue;
            visited[next.e] = true;

            int dist = next.w + dfs(next.e);
            if(val1 < dist) {
                val2 = val1;
                val1 = dist;
            } else if (val2 < dist) {
                val2 = dist;
            }
        }
        result = Math.max(result, val1 + val2);
        return val1; // 자식 노드 중 가장 큰 값
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
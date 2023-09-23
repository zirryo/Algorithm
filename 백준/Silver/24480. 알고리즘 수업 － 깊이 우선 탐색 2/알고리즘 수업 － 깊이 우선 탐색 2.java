import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, cnt = 0;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i=1; i<=N; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        dfs(R);

        for (int i=1; i<=N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int x) {
        visited[x] = ++cnt;
        for (int next : graph[x]) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];
        Arrays.fill(result, -1);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);


    }
    private static void dfs(int node, int depth) {
        visited[node] = true;
        result[node] = depth;

        for (int next : graph[node]) {
            if (visited[next]) continue;
            dfs(next, depth + 1);
        }
    }
}
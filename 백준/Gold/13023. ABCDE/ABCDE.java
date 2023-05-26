import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (result != 0) break;
            backTracking(i, 1);
        }

        System.out.println(result);
    }
    static void backTracking(int idx, int depth) {
        if (depth == 5) {
            result = 1;
            return;
        }

        visited[idx] = true;

        for (int next : graph[idx]) {
            if (visited[next]) continue;
            backTracking(next, depth + 1);
        }

        visited[idx] =false;
    }
}
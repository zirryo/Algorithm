import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1][N + 1];
        dfs(1);

        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append("a").append(path.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int u) {
        for (int v = 1; v <= N; v++) {
            if (u != v && !visited[u][v]) {
                visited[u][v] = true;
                visited[v][u] = true;
                dfs(v);
            }
        }
        path.add(u);
    }
}
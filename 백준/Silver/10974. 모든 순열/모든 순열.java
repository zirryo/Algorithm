import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        arr = new int[N];

        dfs(0);
        System.out.println(sb);
    }
    private static void dfs(int depth) {
        if (depth == N) {
            for (int i : arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
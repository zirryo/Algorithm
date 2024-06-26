import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] permutation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            permutation = new int[N + 1];
            visited = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            int cycleCount = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cycleCount++;
                }
            }
            sb.append(cycleCount).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start) {
        visited[start] = true;
        int next = permutation[start];

        if (!visited[next]) {
            dfs(next);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 1000 * 10;
    static int[][] time;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        time = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (time[i][j] > time[i][k] + time[k][j]){
                        time[i][j] = time[i][k] + time[k][j];
                    }
                }
            }
        }
        visited[K] = true;
        dfs(K, 0, 1);
        System.out.println(result);
    }
    private static void dfs(int cur, int dist, int depth) {
        if (dist >= result) return;
        if (depth == N) {
            result = Math.min(result, dist);
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(i, dist + time[cur][i], depth+1);
                visited[i] = false;
            }
        }
    }
}
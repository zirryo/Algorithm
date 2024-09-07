import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = true;
        int[] dist = new int[N + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == E) {
                break;
            }
            if (cur + 1 <= N && !visited[cur + 1]) {
                visited[cur + 1] = true;
                q.add(cur + 1);
                dist[cur + 1] = dist[cur] + 1;
            }
            if (cur - 1 >= 1 && !visited[cur - 1]) {
                visited[cur - 1] = true;
                q.add(cur - 1);
                dist[cur - 1] = dist[cur] + 1;
            }

            for (int x : graph[cur]) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                    dist[x] = dist[cur] + 1;
                }
            }
        }
        System.out.println(dist[E]);
    }
}

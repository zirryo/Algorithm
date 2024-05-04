import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, max = 0, result = 0;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            int x = Integer.parseInt(br.readLine());
            list[i].add(x);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);

            if (max == N) break;
        }
        System.out.println(result);
    }
    private static void bfs (int start) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            for (int next : list[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }

        if (cnt > max) {
            max = cnt;
            result = start;
        }
    }
}
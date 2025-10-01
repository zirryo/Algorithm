import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B, N, M));
    }

    static int bfs(int A, int B, int start, int target) {
        boolean[] visited = new boolean[MAX + 1];
        int[] dist = new int[MAX + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) return dist[cur];
            int[] moves = {cur + 1, cur - 1, cur + A, cur - A, cur + B, cur - B, cur * A, cur * B};

            for (int next : moves) {
                if (next < 0 || next > MAX) continue;
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        return -1;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) Arrays.fill(dist[i], -1);

        queue.add(new int[]{1, 1});
        dist[1][1] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int x = map[r][c];

            if (r == N && c == M) {
                System.out.println(dist[r][c] - 1);
                return;
            }

            for (int k = 1; k <= x; k++) {
                int nr = r;
                int nc = c + k;
                if (nc > M) break;
                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }

            for (int k = 1; k <= x; k++) {
                int nr = r + k;
                int nc = c;
                if (nr > N) break;
                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
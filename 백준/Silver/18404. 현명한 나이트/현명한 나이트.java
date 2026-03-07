import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], -1);
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            sb.append(dist[targetX][targetY]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curX = curr[0];
            int curY = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
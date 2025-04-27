import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;

            if (y == M - 1 && x == N - 1) {
                return true;
            }

            if (x + 1 < N && map[y][x + 1] == 1 && !visited[y][x + 1]) {
                visited[y][x + 1] = true;
                queue.add(new Point(y, x + 1));
            }

            if (y + 1 < M && map[y + 1][x] == 1 && !visited[y + 1][x]) {
                visited[y + 1][x] = true;
                queue.add(new Point(y + 1, x));
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = bfs();
        System.out.println(result ? "Yes" : "No");
    }
}

import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] == '#') {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (!visited[nx][ny] && map[nx][ny] == '#') {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}

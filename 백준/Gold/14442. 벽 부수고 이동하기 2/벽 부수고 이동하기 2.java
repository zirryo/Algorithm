import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, dist, broken;
    public Point(int x, int y, int dist, int broken) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.broken = broken;
    }
}
public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0) { // 길
                    if (!visited[nx][ny][cur.broken]) {
                        visited[nx][ny][cur.broken] = true;
                        q.add(new Point(nx, ny, cur.dist + 1, cur.broken));
                    }
                } else { // 벽
                    if (cur.broken < K && !visited[nx][ny][cur.broken + 1]) {
                        visited[nx][ny][cur.broken + 1] = true;
                        q.add(new Point(nx, ny, cur.dist + 1, cur.broken + 1));
                    }
                }
            }
        }

        return -1;
    }
}
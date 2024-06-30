import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalScore = 0;

        while (true) {
            visited = new boolean[N][N];
            List<Point> maxGroup = null;
            int maxRainbow = -1;
            Point baseBlock = null;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        List<Point> group = bfs(i, j);
                        if (group.size() < 2) continue;

                        int rainbow = 0;
                        Point standardBlock = new Point(N, N);
                        for (Point p : group) {
                            if (map[p.x][p.y] == 0) rainbow++;
                            else if (p.x < standardBlock.x || (p.x == standardBlock.x && p.y < standardBlock.y)) {
                                standardBlock = p;
                            }
                        }

                        if (maxGroup == null || group.size() > maxGroup.size() ||
                                (group.size() == maxGroup.size() && (rainbow > maxRainbow ||
                                        (rainbow == maxRainbow && (standardBlock.x > baseBlock.x ||
                                                (standardBlock.x == baseBlock.x && standardBlock.y > baseBlock.y)))))) {
                            maxGroup = group;
                            maxRainbow = rainbow;
                            baseBlock = standardBlock;
                        }

                    }
                }
            }

            if (maxGroup == null) break;

            for (Point p : maxGroup) {
                map[p.x][p.y] = -2; // Remove block
            }
            totalScore += maxGroup.size() * maxGroup.size();

            applyGravity();
            rotateMap();
            applyGravity();
        }

        System.out.println(totalScore);
    }

    static List<Point> bfs(int x, int y) {
        List<Point> group = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        boolean[][] tempVisited = new boolean[N][N];
        queue.add(new Point(x, y));
        tempVisited[x][y] = true;
        visited[x][y] = true;

        int color = map[x][y];

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            group.add(cur);

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || tempVisited[nx][ny]) continue;
                if (map[nx][ny] == color || map[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    tempVisited[nx][ny] = true;
                    if (map[nx][ny] != 0) visited[nx][ny] = true;
                }
            }
        }

        return group;
    }

    static void applyGravity() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] > -1) {
                    int nx = i;
                    while (nx + 1 < N && map[nx + 1][j] == -2) {
                        map[nx + 1][j] = map[nx][j];
                        map[nx][j] = -2;
                        nx++;
                    }
                }
            }
        }
    }

    static void rotateMap() {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[N - 1 - j][i] = map[i][j];
            }
        }
        map = rotated;
    }
}
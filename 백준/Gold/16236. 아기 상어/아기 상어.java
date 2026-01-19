import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int sharkX, sharkY, sharkSize = 2, eatCnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        int totalTime = 0;
        while (true) {
            Fish target = findTarget();
            if (target == null) break;

            totalTime += target.dist;
            eatCnt++;
            if (eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }

            sharkX = target.x;
            sharkY = target.y;
            map[sharkX][sharkY] = 0;
        }

        System.out.println(totalTime);
    }

    static Fish findTarget() {
        PriorityQueue<Fish> pq = new PriorityQueue<>(); // 물고기 우선순위 비교 후 먹을 물고기 선정(타겟)
        Queue<int[]> q = new LinkedList<>(); // BFS 맵 탐색
        boolean[][] visited = new boolean[N][N];

        q.add(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] <= sharkSize) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, curr[2] + 1});

                        if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                            pq.add(new Fish(nx, ny, curr[2] + 1));
                        }
                    }
                }
            }
        }

        return pq.poll();
    }

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            if (this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M, T;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[][] original = new int[N][M * 3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0 ; k < M * 3; k++) {
                original[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = j * 3;
                map[i][j] = (original[i][tmp] + original[i][tmp + 1] + original[i][tmp + 2]) / 3;
            }
        }

        T = Integer.parseInt(br.readLine());

        System.out.println(solve());
    }

    static int solve() {
        Queue<int[]> q;
        boolean[][] visited = new boolean[N][M];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || map[i][j] < T) continue;
                visited[i][j] = true;
                q = new LinkedList<>();
                q.add(new int[]{i, j});
                result++;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = cur[0] + dx[k];
                        int y = cur[1] + dy[k];
                        if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] < T) continue;
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return result;
    }
}
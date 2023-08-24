import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = 0;
    static boolean flag;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j]) continue;
                flag = true;
                dfs(i, j);
                if (flag) result++;
            }
        }
        System.out.println(result);
    }
    private static void dfs(int r, int c) {
        check[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            if (map[nr][nc] > map[r][c]) flag = false;
            if (check[nr][nc] || map[nr][nc] < map[r][c]) continue;
            if (map[nr][nc] == map[r][c]) dfs(nr, nc);
        }
    }
}
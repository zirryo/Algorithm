import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max = -9999, min = 9999; // 최댓값: 3125, 최솟값: -625
    static char[][] map;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        dfs(0, 0, map[0][0] - '0');
        System.out.printf("%d %d", max, min);
    }
    private static void dfs(int r, int c, int cur) {
        if (r == N - 1 && c == N - 1) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= N || nc >= N) continue;

            int next = cur;

            if (map[r][c] == '+') {
                next += map[nr][nc] - '0';
            } else if (map[r][c] == '-') {
                next -= map[nr][nc] - '0';
            } else if (map[r][c] == '*') {
                next *= map[nr][nc] - '0';
            }

            dfs(nr, nc, next);
        }
    }
}
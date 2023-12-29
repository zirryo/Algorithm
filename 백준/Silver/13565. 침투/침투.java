import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] map; // '0' - 전류통함, '1' - 전류 통하지 않음
    static boolean PERCOLATE = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int j=0; j<M; j++) {
            if (map[0][j] == '0') {
                dfs(0, j);
                if (PERCOLATE) break;
            }
        }

        if (PERCOLATE) System.out.println("YES");
        else System.out.println("NO");
    }
    private static void dfs(int r, int c) {
        if (r == N - 1) {
            PERCOLATE = true;
            return;
        }

        map[r][c] = '2'; // 방문표시

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (map[nr][nc] == '0') dfs(nr, nc);
        }
    }
}
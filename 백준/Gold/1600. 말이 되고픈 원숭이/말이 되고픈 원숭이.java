import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, ans;
    static boolean[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] jr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] jc = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int INF = 200 * 200;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pos> q = new LinkedList<>();
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        ans = INF;
        map = new boolean[N][M];
        visited = new boolean[N][M][K+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) map[i][j] = true;
            }
        }
        q.add(new Pos(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1) {
                ans = Math.min(ans, cur.cnt);
                continue;
            }
            for(int i=0; i<4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                if(valid(nr, nc)) {
                    if(!map[nr][nc] && !visited[nr][nc][cur.jump]) {
                        q.add(new Pos(nr, nc, cur.cnt+1, cur.jump));
                        visited[nr][nc][cur.jump] = true;
                    }
                }
            }
            if(cur.jump < K) {
                for(int i=0; i<8; i++) {
                    int nr = jr[i] + cur.r;
                    int nc = jc[i] + cur.c;
                    if(valid(nr, nc)) {
                        if(!map[nr][nc] && !visited[nr][nc][cur.jump+1]) {
                            q.add(new Pos(nr, nc, cur.cnt+1, cur.jump+1));
                            visited[nr][nc][cur.jump+1] = true;
                        }
                    }
                }
            }
        }
        if(ans == INF) ans = -1;
        System.out.println(ans);
    }
    private static boolean valid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
    private static class Pos {
        int r;
        int c;
        int cnt;
        int jump;

        public Pos(int r, int c, int cnt, int jump) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.jump = jump;
        }
    }
}
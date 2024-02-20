import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        bfs(r1, c1, r2, c2);
    }

    private static void bfs(int r1, int c1, int r2, int c2) {
        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r1, c1));
        visited[r1][c1] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= N || nr < 0 || nc >= N || nc < 0 || visited[nr][nc]) continue;
                if (nr == r2 && nc == c2) {
                    System.out.println(map[cur.r][cur.c] + 1);
                    return;
                }

                q.add(new Pos(nr, nc));
                visited[nr][nc] = true;
                map[nr][nc] = map[cur.r][cur.c] + 1;
            }
        }

        System.out.println(-1);
    }
}
class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
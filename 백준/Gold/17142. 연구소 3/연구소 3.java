import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Pos> startPoint = new ArrayList<>();
    static int N, M, cnt = 0, result = 50 * 50, zeroArea = 0;
    static int[][] map;
    static int[] activate;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startPoint.add(new Pos(i, j, 0));
                    cnt++;
                } else if(map[i][j] == 0) zeroArea++;
            }
        }

        activate = new int[M];
        if (zeroArea == 0) System.out.println(0);
        else {
            combination(0, 0);
            if (result == 50 * 50) System.out.println(-1);
            else System.out.println(result);
        }
    }
    private static void combination(int idx, int depth) {
        if (depth == M) {
            spreadVirus(zeroArea);
            return;
        }
        for (int i = idx; i < cnt; i++) {
            activate[depth] = i;
            combination(i+1, depth+1);
            activate[depth] = 0;
        }
    }
    private static void spreadVirus(int zero) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (int idx : activate) {
            Pos start = startPoint.get(idx);
            q.add(new Pos(start.r, start.c, 0));
            visited[start.r][start.c] = true;
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (!isValid(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                if (map[nr][nc] == 0) zero--;
                if (zero == 0) {
                    result = Math.min(result, cur.cost + 1);
                    return;
                }

                visited[nr][nc] = true;
                q.add(new Pos(nr, nc, cur.cost + 1));
            }
        }
    }
    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    private static class Pos {
        int r;
        int c;
        int cost;

        public Pos(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}
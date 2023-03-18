import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, total;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        init();
        int finalCnt = 0;
        int cnt = 0;
        while(total > 0) {
            finalCnt = total;
            cnt++;
            visited = new boolean[N][M];
            bfs();
        }
        System.out.println(cnt + "\n" + finalCnt);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) total++; // 총 치즈 개수 카운트
            }
        }
    }
    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if(map[nr][nc] == 1) {
                        total--;
                        map[nr][nc] = 0;
                    } else {
                        q.add(new Pos(nr, nc));
                    }
                }
            }
        }
    }
    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
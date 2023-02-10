import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static final int INF = 50 * 50;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        init();
        int result = bfs();
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
    }

    private static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        int[][] minCnt = new int[N][N];

        for(int i=0; i<N; i++) Arrays.fill(minCnt[i], INF);

        minCnt[0][0] = 0; // 시작점 (0, 0)
        q.add(new Pos(0, 0, minCnt[0][0]));

        while(!q.isEmpty()) {
            Pos curPos = q.poll();

            for(int i=0; i<4; i++) {
                int nr = curPos.r + dr[i];
                int nc = curPos.c + dc[i];
                int nextCnt = curPos.cnt;

                if(nr<0 || nr>=N || nc<0 || nc >=N) continue; // 이동 불가능 위치
                if(map[nr][nc] == 0) nextCnt++; // 검은 방 이라면 흰 방으로 교체
                if(nextCnt >= minCnt[nr][nc]) continue; // 최솟값이 아니라면 갱신하지 않음

                minCnt[nr][nc] = nextCnt; // 더 작은 값이라면 갱신
                q.add(new Pos(nr, nc, nextCnt));
            }
        }
        return minCnt[N-1][N-1];
    }

    static class Pos {
        int r;
        int c;
        int cnt;

        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}